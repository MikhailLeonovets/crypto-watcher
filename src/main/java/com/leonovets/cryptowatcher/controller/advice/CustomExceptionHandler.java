package com.leonovets.cryptowatcher.controller.advice;

import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;
import com.leonovets.cryptowatcher.service.exception.NullBodyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Mikhail.Leonovets
 * @since 05/16/2023 - 16:27
 */
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(final EntityNotFoundException entityNotFoundException) {
        log.warn(entityNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityNotFoundException.getMessage());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<?> handleEntityAlreadyExistsException(final EntityAlreadyExistsException entityAlreadyExistsException) {
        log.warn(entityAlreadyExistsException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(entityAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(NullBodyException.class)
    public ResponseEntity<?> handleNullBodyException(final NullBodyException nullBodyException) {
        log.warn(nullBodyException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(nullBodyException.getMessage());
    }
}
