package com.leonovets.cryptowatcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mikhail.Leonovets
 * @since 05/14/2023 - 23:54
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<?> registerUser() {
        return null;
    }

}
