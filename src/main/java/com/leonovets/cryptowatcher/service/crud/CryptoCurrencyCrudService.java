package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
public interface CryptoCurrencyCrudService {

    List<CryptoCurrency> saveAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityAlreadyExistsException;

    List<CryptoCurrency> saveOrUpdateAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityAlreadyExistsException;


    CryptoCurrency save(final CryptoCurrency cryptoCurrency) throws EntityAlreadyExistsException;

    List<CryptoCurrency> findAll();

    CryptoCurrency findBySymbol(final String symbol) throws EntityNotFoundException;

    CryptoCurrency update(final CryptoCurrency cryptoCurrency) throws EntityNotFoundException;

    List<CryptoCurrency> updateAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityNotFoundException;

}
