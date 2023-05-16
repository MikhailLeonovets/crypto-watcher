package com.leonovets.cryptowatcher.service.business;

/**
 * Service which used to update cryptocurrencies information in the API
 *
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 20:19
 */
public interface CryptoCurrencyUpdaterService {

    /**
     * Used to update cryptocurrencies information in the API
     * Also, logs business information
     */
    void cryptoCurrencyUpdate();

}
