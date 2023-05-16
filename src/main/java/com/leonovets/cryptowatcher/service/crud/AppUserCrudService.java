package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AppUser CRUD Service using for CRUD Operations in the database using repository
 *
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
@Repository
public interface AppUserCrudService {

    /**
     * Saves AppUser in the database using repository
     *
     * @param appUser to be saved
     * @return saved AppUser entity
     * @throws EntityAlreadyExistsException if AppUser is already exists in the database
     */
    AppUser save(final AppUser appUser) throws EntityAlreadyExistsException;

    /**
     * Find list of AppUsers which have needed cryptocurrency id
     *
     * @param cryptoCurrencyId is the needed cryptocurrency id
     * @return list of AppUser entities have needed cryptocurrency id
     */
    List<AppUser> findAllByCryptoCurrency_Id(final Long cryptoCurrencyId);

}
