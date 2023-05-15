package com.leonovets.cryptowatcher.service.business;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 22:04
 */
public interface CryptoCurrencyOpenApiConsumerService<PARAM> {

    List<CryptoCurrency> getCryptoCurrencies(final List<PARAM> ids);

}
