package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;

import java.util.List;

/**
 * Crypto Currency CRUD Service for CRUD operations with an Entity CryptoCurrency
 * {@link com.leonovets.cryptowatcher.repository.entity.CryptoCurrency} using Repository
 *
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
public interface CryptoCurrencyCrudService {

    /**
     * Saving list of CryptoCurrency entities into database using repository
     *
     * @param cryptoCurrencies to be saved
     * @return list of saved entities
     * @throws EntityAlreadyExistsException if entities already existed in the database
     */
    List<CryptoCurrency> saveAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityAlreadyExistsException;

    /**
     * Saves new entities or updates existed into database using repository
     *
     * @param cryptoCurrencies to be saved or updated
     * @return list of saved or updated entities
     */
    List<CryptoCurrency> saveOrUpdateAll(final List<CryptoCurrency> cryptoCurrencies);

    /**
     * Saves a CryptoCurrency entity into database using repository
     *
     * @param cryptoCurrency to be saved
     * @return saved entity
     * @throws EntityAlreadyExistsException if entity already existed
     */
    CryptoCurrency save(final CryptoCurrency cryptoCurrency) throws EntityAlreadyExistsException;

    /**
     * Finds all CryptoCurrency in the database using repository
     *
     * @return all CryptoCurrency entities from the database
     */
    List<CryptoCurrency> findAll();

    /**
     * Finds a CryptoCurrency entity in the database using repository by symbol
     *
     * @param symbol is a key using to find an entity
     * @return CryptoCurrency entity from the database with needed symbol
     * @throws EntityNotFoundException if it is not found
     */
    CryptoCurrency findBySymbol(final String symbol) throws EntityNotFoundException;

    /**
     * Updates CryptoCurrency entity in the database using repository
     *
     * @param cryptoCurrency to be updated with updated fields
     * @return CryptoCurrency updated entity
     * @throws EntityNotFoundException if entity is not found to be updated
     */
    CryptoCurrency update(final CryptoCurrency cryptoCurrency) throws EntityNotFoundException;

    /**
     * Updates list of CryptoCurrency entities in the database using repository
     *
     * @param cryptoCurrencies to be updated
     * @return updated list of CryptoCurrency entities
     * @throws EntityNotFoundException if some of the entities are not found in the database
     */
    List<CryptoCurrency> updateAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityNotFoundException;

}
