package com.leonovets.cryptowatcher.service.business.impl;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.AppUserService;
import com.leonovets.cryptowatcher.service.crud.AppUserCrudService;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import com.leonovets.cryptowatcher.service.dto.AppUserDto;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 17:44
 */
@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserCrudService appUserCrudService;
    private final CryptoCurrencyCrudService cryptoCurrencyCrudService;

    @Transactional
    @Override
    public void registerAppUser(final AppUserDto appUserDto) throws EntityNotFoundException, EntityAlreadyExistsException {
        final CryptoCurrency cryptoCurrency = cryptoCurrencyCrudService.findBySymbol(appUserDto.getCryptoSymbol());
        final AppUser appUser = new AppUser();
        appUser.setUsername(appUserDto.getUsername());
        appUser.setCryptoCurrency(cryptoCurrency);
        appUser.setFirstCryptoPrice(cryptoCurrency.getCurrentPrice());
        appUserCrudService.save(appUser);
    }
}
