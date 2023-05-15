package com.leonovets.cryptowatcher.service.exception;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 14:07
 */
public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(final String message) {
        super(message);
    }
}
