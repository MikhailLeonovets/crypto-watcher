package com.leonovets.cryptowatcher.service.business;

import com.leonovets.cryptowatcher.service.dto.AppUserDto;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:31
 */
public interface AppUserService {

    void registerAppUser(final AppUserDto appUserDto) throws EntityNotFoundException, EntityAlreadyExistsException;

}
