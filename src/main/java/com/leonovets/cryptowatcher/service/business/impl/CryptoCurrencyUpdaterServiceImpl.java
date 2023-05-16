package com.leonovets.cryptowatcher.service.business.impl;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyOpenApiConsumerService;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyUpdaterService;
import com.leonovets.cryptowatcher.service.crud.AppUserCrudService;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 20:32
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CryptoCurrencyUpdaterServiceImpl implements CryptoCurrencyUpdaterService {
    private final CryptoCurrencyCrudService cryptoCurrencyCrudService;
    private final CryptoCurrencyOpenApiConsumerService<String> cryptoCurrencyOpenApiConsumerService;
    private final AppUserCrudService appUserCrudService;

    @SneakyThrows
    @Transactional
    @Override
    public void cryptoCurrencyUpdate() {
        final List<CryptoCurrency> cryptoCurrenciesFromDb = cryptoCurrencyCrudService.findAll();
        final List<String> ids = cryptoCurrenciesFromDb.stream()
                .map(cryptoCurrency -> cryptoCurrency.getId().toString())
                .toList();
        final List<CryptoCurrency> cryptoCurrenciesFromOpenApi = cryptoCurrencyOpenApiConsumerService.getCryptoCurrencies(ids);
        for (final CryptoCurrency cryptoCurrencyFromDb : cryptoCurrenciesFromDb) {
            final CryptoCurrency cryptoCurrencyFromOpenApi = cryptoCurrenciesFromOpenApi
                    .stream()
                    .filter(cryptoCurrency -> cryptoCurrency.getId().equals(cryptoCurrencyFromDb.getId()))
                    .findFirst().orElseThrow();
            final float percentChange = cryptoCurrencyFromOpenApi.getCurrentPrice()
                    .setScale(2, RoundingMode.HALF_UP)
                    .divide(cryptoCurrencyFromDb.getCurrentPrice(), RoundingMode.HALF_UP)
                    .subtract(new BigDecimal(1))
                    .multiply(new BigDecimal(100))
                    .floatValue();
            if (Math.abs(percentChange) >= 1F) {
                for (final AppUser appUser : appUserCrudService.findAllByCryptoCurrency_Id(cryptoCurrencyFromDb.getId())) {
                    final float priceChangesForUser = cryptoCurrencyFromOpenApi.getCurrentPrice()
                            .setScale(4, RoundingMode.HALF_UP)
                            .divide(appUser.getFirstCryptoPrice(), RoundingMode.HALF_UP)
                            .subtract(new BigDecimal(1))
                            .multiply(new BigDecimal(100))
                            .setScale(2, RoundingMode.HALF_UP)
                            .floatValue();
                    log.warn("CryptoCurrency symbol: " + cryptoCurrencyFromDb.getSymbol()
                            + ", Username: " + appUser.getUsername()
                            + ", Percent changes for all the time: " + priceChangesForUser
                            + "%.");
                }
            }
        }
        cryptoCurrencyCrudService.updateAll(cryptoCurrenciesFromOpenApi);
    }

}
