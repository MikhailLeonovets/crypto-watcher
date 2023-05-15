package com.leonovets.cryptowatcher.service.crud;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import org.springframework.stereotype.Repository;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:00
 */
@Repository
public interface AppUserCrudService {

    void save(final AppUser appUser);

}
