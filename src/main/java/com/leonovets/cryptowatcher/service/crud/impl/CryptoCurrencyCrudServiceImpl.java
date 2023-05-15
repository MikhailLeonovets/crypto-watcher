package com.leonovets.cryptowatcher.service.crud.impl;

import static com.leonovets.cryptowatcher.service.constants.ExceptionMessage.CRYPTO_CURRENCY_ALREADY_EXISTS;
import static com.leonovets.cryptowatcher.service.constants.ExceptionMessage.CRYPTO_CURRENCY_NOT_FOUND;
import com.leonovets.cryptowatcher.repository.CryptoCurrencyRepository;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import com.leonovets.cryptowatcher.service.exception.EntityAlreadyExistsException;
import com.leonovets.cryptowatcher.service.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 14:30
 */
@RequiredArgsConstructor
@Service
public class CryptoCurrencyCrudServiceImpl implements CryptoCurrencyCrudService {
    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    @Transactional
    @Override
    public List<CryptoCurrency> saveAll(final List<CryptoCurrency> cryptoCurrencies) throws EntityAlreadyExistsException {
        final List<CryptoCurrency> cryptoCurrenciesExisted = cryptoCurrencies.stream()
                .filter(cryptoCurrency -> cryptoCurrencyRepository.findBySymbol(cryptoCurrency.getSymbol()).isPresent())
                .toList();
        if (cryptoCurrenciesExisted.size() > 0) {
            StringBuilder message = new StringBuilder();
            cryptoCurrenciesExisted
                    .forEach(cryptoCurrency -> message.append(
                            String.format(CRYPTO_CURRENCY_ALREADY_EXISTS + "\n", cryptoCurrency.getSymbol()
                            )));
            throw new EntityAlreadyExistsException(message.toString());
        }

        return cryptoCurrencyRepository.saveAll(cryptoCurrencies);
    }

    @Transactional
    @Override
    public CryptoCurrency save(final CryptoCurrency cryptoCurrency) throws EntityAlreadyExistsException {
        if (cryptoCurrencyRepository.findBySymbol(cryptoCurrency.getSymbol()).isPresent()) {
            throw new EntityAlreadyExistsException(String.format(CRYPTO_CURRENCY_ALREADY_EXISTS, cryptoCurrency.getSymbol()));
        }
        return cryptoCurrencyRepository.save(cryptoCurrency);
    }

    @Transactional
    @Override
    public CryptoCurrency update(final CryptoCurrency cryptoCurrency) throws EntityNotFoundException {
        if (cryptoCurrencyRepository.findById(cryptoCurrency.getId()).isEmpty()) {
            throw new EntityNotFoundException(String.format(CRYPTO_CURRENCY_NOT_FOUND, cryptoCurrency.getId()));
        }
        return cryptoCurrencyRepository.save(cryptoCurrency);
    }
}
