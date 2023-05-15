package com.leonovets.cryptowatcher.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "app_user")
public class AppUser {
    @Id
    private Long id;
    @Column(name = "username")
    private String username;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crypto_currency_id")
    private CryptoCurrency cryptoCurrency;
    @Column(name = "first_crypto_price")
    private BigDecimal firstCryptoPrice;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final AppUser appUser = (AppUser) o;
        return getId() != null && Objects.equals(getId(), appUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, cryptoCurrency, firstCryptoPrice);
    }
}
