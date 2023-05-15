package com.leonovets.cryptowatcher.service.business.impl;

import com.leonovets.cryptowatcher.service.business.AppUserService;
import com.leonovets.cryptowatcher.service.dto.AppUserDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 17:44
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Transactional
    @Override
    public void registerAppUser(final AppUserDto appUserDto) {

    }
}
