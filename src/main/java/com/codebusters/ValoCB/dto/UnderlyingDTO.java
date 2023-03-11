package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for the Underlying.
 */
@Data
@NoArgsConstructor
public class UnderlyingDTO {

    /**
     * Name of the underlying.
     */
    private String name;

    /**
     * Currency of the price of the underlying.
     */
    private String currency;

    /**
     * Price of the underlying.
     */
    private Long price;

    /**
     * Constructor full for the underlying.
     * @param name - name of the underlying
     * @param currency - currency of the underlying
     * @param price - price of the underlying
     */
    public UnderlyingDTO(String name, String currency, Long price) {
        this.name = name;
        this.currency = currency;
        this.price = price;
    }
}
