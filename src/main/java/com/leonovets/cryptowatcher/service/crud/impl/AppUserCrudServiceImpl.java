package com.leonovets.cryptowatcher.service.crud.impl;

import static com.leonovets.cryptowatcher.service.constants.ExceptionMessage.APP_USER_ALREADY_EXISTS;
import com.leonovets.cryptowatcher.repository.AppUserRepository;
import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.service.crud.AppUserCrudService;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 14:02
 */
@RequiredArgsConstructor
@Service
public class AppUserCrudServiceImpl implements AppUserCrudService {
    private final AppUserRepository appUserRepository;

    @Transactional
    @Override
    public AppUser save(final AppUser appUser) throws EntityAlreadyExistsException {
        if (appUserRepository.findByUsername(appUser.getUsername()).isPresent()) {
            throw new EntityAlreadyExistsException(String.format(APP_USER_ALREADY_EXISTS, appUser.getUsername()));
        }
        return appUserRepository.save(appUser);
    }
}
