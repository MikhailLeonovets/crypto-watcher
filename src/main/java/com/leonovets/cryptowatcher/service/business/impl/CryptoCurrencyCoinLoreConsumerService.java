package com.leonovets.cryptowatcher.service.business.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyOpenApiConsumerService;
import com.leonovets.cryptowatcher.service.mapper.CryptoCurrencyFromCoinLoreDeserializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 22:11
 */

public class CryptoCurrencyCoinLoreConsumerService implements CryptoCurrencyOpenApiConsumerService<String> {
    private ObjectMapper objectMapper;

    @Override
    public List<CryptoCurrency> getCryptoCurrencies(final List<String> ids) throws JsonProcessingException {
        final String url = "https://api.coinlore.net/api/ticker/?id=";
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> response = restTemplate.getForEntity(url + String.join(",", ids), String.class);
        return getObjectMapperForCryptoCurrencyFromCoinLore().readValue(
                response.getBody(), new TypeReference<List<CryptoCurrency>>() {
                });
    }

    private ObjectMapper getObjectMapperForCryptoCurrencyFromCoinLore() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            final SimpleModule simpleModule = new SimpleModule();
            simpleModule.addDeserializer(CryptoCurrency.class, new CryptoCurrencyFromCoinLoreDeserializer());
            objectMapper.registerModule(simpleModule);
        }
        return objectMapper;
    }
}
