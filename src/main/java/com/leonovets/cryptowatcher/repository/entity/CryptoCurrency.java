package com.leonovets.cryptowatcher.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 00:06
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "crypto_currency")
public class CryptoCurrency {
    @Id
    private Long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "current_price")
    private BigDecimal currentPrice;

}
