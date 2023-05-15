package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
@Repository
public interface AppUserCrudService {

    AppUser save(final AppUser appUser) throws EntityAlreadyExistsException;

    List<AppUser> findAllByCryptoCurrency_Id(final Long cryptoCurrencyId);

}
