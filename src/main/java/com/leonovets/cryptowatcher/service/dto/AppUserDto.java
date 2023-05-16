package com.leonovets.cryptowatcher.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 17:41
 */
@ToString
@Getter
@Setter
public class AppUserDto {
    private String username;
    private String cryptoSymbol;

}
