package com.leonovets.cryptowatcher.service.constants;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 14:10
 */
public interface ExceptionMessage {
    String APP_USER_ALREADY_EXISTS = "User with \"%s\" username already exists";
    String APP_USER_NOT_FOUND = "User with \"%s\" username not found";

    String CRYPTO_CURRENCY_ALREADY_EXISTS = "Crypto currency with \"%s\" symbol already exists";
    String CRYPTO_CURRENCY_NOT_FOUND = "Crypto currency with \"%s\" id not found";
}
