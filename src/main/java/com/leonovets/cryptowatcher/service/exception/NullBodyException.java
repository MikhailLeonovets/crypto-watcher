package com.leonovets.cryptowatcher.service.exception;

/**
 * @author Mikhail.Leonovets
 * @since 05/16/2023 - 16:31
 */
public class NullBodyException extends Exception {
    public NullBodyException(final String message) {
        super(message);
    }
}
