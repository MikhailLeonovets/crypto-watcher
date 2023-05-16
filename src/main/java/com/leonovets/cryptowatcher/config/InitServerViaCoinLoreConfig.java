package com.leonovets.cryptowatcher.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyOpenApiConsumerService;
import com.leonovets.cryptowatcher.service.business.impl.CryptoCurrencyCoinLoreConsumerService;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/16/2023 - 11:29
 */
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "crypto_currency.watcher", name = "open_api", havingValue = "coin_lore")
@Configuration
public class InitServerViaCoinLoreConfig {
    private final CryptoCurrencyCrudService cryptoCurrencyCrudService;

    @SneakyThrows
    @Bean
    public CryptoCurrencyOpenApiConsumerService<String> cryptoCurrencyCoinLoreConsumerService() {
        final CryptoCurrencyCoinLoreConsumerService cryptoCurrencyCoinLoreConsumerService = new CryptoCurrencyCoinLoreConsumerService();
        final List<CryptoCurrency> cryptoCurrencies = cryptoCurrencyCoinLoreConsumerService.getCryptoCurrencies(
                readCryptoCurrenciesPreconfigFile().stream()
                        .map(cryptoCurrency -> cryptoCurrency.getId().toString())
                        .toList());
        cryptoCurrencyCrudService.saveAll(cryptoCurrencies);
        return cryptoCurrencyCoinLoreConsumerService;
    }

    @SneakyThrows
    private List<CryptoCurrency> readCryptoCurrenciesPreconfigFile() {
        return new ObjectMapper().readValue(new File("/cryptocurrencies_coinlore_preconfig.json"),
                new TypeReference<List<CryptoCurrency>>() {
                });
    }
}
