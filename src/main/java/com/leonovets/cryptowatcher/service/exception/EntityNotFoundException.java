package com.leonovets.cryptowatcher.service.exception;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 13:08
 */
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(final String message) {
        super(message);
    }
}
