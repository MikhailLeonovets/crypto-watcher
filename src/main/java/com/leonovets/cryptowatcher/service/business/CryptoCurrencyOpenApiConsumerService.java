package com.leonovets.cryptowatcher.service.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;

import java.util.List;

/**
 * Service used to load some cryptocurrencies information from Open API
 *
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 22:04
 */
public interface CryptoCurrencyOpenApiConsumerService<PARAM> {

    /**
     * Loads some cryptocurrencies information
     *
     * @param params are the URL params which used to create a Response to Open API
     * @return list of CryptoCurrency entities
     * @throws JsonProcessingException if Open API response could not be parsed
     */
    List<CryptoCurrency> getCryptoCurrencies(final List<PARAM> params) throws JsonProcessingException;

}
