package com.leonovets.cryptowatcher.service.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 21:26
 */
public class CryptoCurrencyFromCoinLoreDeserializer extends StdDeserializer<CryptoCurrency> {
    public CryptoCurrencyFromCoinLoreDeserializer() {
        this(null);
    }

    public CryptoCurrencyFromCoinLoreDeserializer(final Class<CryptoCurrency> t) {
        super(t);
    }

    @Override
    public CryptoCurrency deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        final JsonNode node = p.getCodec().readTree(p);
        final CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(Long.parseLong(node.get("id").asText()));
        cryptoCurrency.setSymbol(node.get("symbol").asText());
        cryptoCurrency.setCurrentPrice(BigDecimal.valueOf(Double.parseDouble(node.get("price_usd").asText())));
        return cryptoCurrency;
    }
}
