package com.leonovets.cryptowatcher.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final CryptoCurrency that = (CryptoCurrency) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, currentPrice);
    }
}
