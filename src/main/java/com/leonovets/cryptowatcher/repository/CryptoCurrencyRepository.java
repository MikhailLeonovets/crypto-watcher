package com.leonovets.cryptowatcher.repository;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 00:29
 */
@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findBySymbol(final String symbol);

}
