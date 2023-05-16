package com.leonovets.cryptowatcher.service.business;

import com.leonovets.cryptowatcher.service.dto.AppUserDto;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;

/**
 * AppUser Service used to some business logic operations in the API
 *
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 12:31
 */
public interface AppUserService {

    /**
     * Registers App User in the API
     *
     * @param appUserDto dto which has needed fields to create AppUser
     * @throws EntityNotFoundException      if there is no needed CryptoCurrency in the API
     * @throws EntityAlreadyExistsException if AppUser already created
     */
    void registerAppUser(final AppUserDto appUserDto) throws EntityNotFoundException, EntityAlreadyExistsException;

}
