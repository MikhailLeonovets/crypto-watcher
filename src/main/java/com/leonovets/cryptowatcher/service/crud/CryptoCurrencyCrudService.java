package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
public interface CryptoCurrencyCrudService {

    void saveAll(final List<CryptoCurrency> cryptoCurrencies);

    void save(final CryptoCurrency cryptoCurrency);

    void update(final CryptoCurrency cryptoCurrency);

}
