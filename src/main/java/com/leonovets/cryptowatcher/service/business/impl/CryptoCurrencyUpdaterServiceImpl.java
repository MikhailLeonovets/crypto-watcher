package com.leonovets.cryptowatcher.service.business.impl;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyOpenApiConsumerService;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyUpdaterService;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 20:32
 */
@RequiredArgsConstructor
@Service
public class CryptoCurrencyUpdaterServiceImpl implements CryptoCurrencyUpdaterService {
    private final CryptoCurrencyCrudService cryptoCurrencyCrudService;
    private final CryptoCurrencyOpenApiConsumerService<String> cryptoCurrencyOpenApiConsumerService;

    @Transactional
    @Override
    public void cryptoCurrencyUpdate() {
        final List<CryptoCurrency> cryptoCurrenciesFromDb = cryptoCurrencyCrudService.findAll();
        final List<String> ids = cryptoCurrenciesFromDb.stream()
                .map(cryptoCurrency -> cryptoCurrency.getId().toString())
                .toList();
        final List<CryptoCurrency> cryptoCurrenciesFromOpenApi = cryptoCurrencyOpenApiConsumerService.getCryptoCurrencies(ids);


    }

}
