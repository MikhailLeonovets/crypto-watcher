package com.leonovets.cryptowatcher.controller;

import static com.leonovets.cryptowatcher.service.constants.ExceptionMessage.NULL_BODY;
import com.leonovets.cryptowatcher.service.business.AppUserService;
import com.leonovets.cryptowatcher.service.dto.AppUserDto;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;
import com.leonovets.cryptowatcher.service.exception.NullBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 05/14/2023 - 23:54
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final AppUserService appUserService;

    @PostMapping("/user")
    public ResponseEntity<?> registerAppUser(@RequestBody final AppUserDto appUserDto) throws EntityAlreadyExistsException,
            EntityNotFoundException, NullBodyException {
        if (appUserDto == null
                || appUserDto.getUsername() == null
                || appUserDto.getCryptoSymbol() == null) {
            throw new NullBodyException(NULL_BODY);
        }
        appUserService.registerAppUser(appUserDto);
        return ResponseEntity.ok("User created successfully");
    }

}
