package com.leonovets.cryptowatcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 05/14/2023 - 23:46
 */
@RestController
@RequestMapping("/api")
public class CryptoCurrencyController {

    @GetMapping("/crypto-currency")
    public ResponseEntity<?> getAllCryptoCurrency() {
        return null; //TODO
    }

    @GetMapping("/crypto-currency/{cryptoCode}")
    public ResponseEntity<?> getCryptoCurrency(@PathVariable(name = "cryptoCode") final String cryptoCode) {
        return null; //TODO
    }

}
