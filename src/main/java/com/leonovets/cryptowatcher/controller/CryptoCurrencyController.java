package com.leonovets.cryptowatcher.controller;

import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 05/14/2023 - 23:46
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CryptoCurrencyController {
    private final CryptoCurrencyCrudService cryptoCurrencyCrudService;

    @GetMapping("/crypto-currency")
    public ResponseEntity<?> getAllCryptoCurrency() {
        return ResponseEntity.ok(cryptoCurrencyCrudService.findAll());
    }

    @GetMapping("/crypto-currency/{symbol}")
    public ResponseEntity<?> getCryptoCurrency(@PathVariable(name = "symbol") final String symbol) throws EntityNotFoundException {
        return ResponseEntity.ok(cryptoCurrencyCrudService.findBySymbol(symbol));
    }

}
