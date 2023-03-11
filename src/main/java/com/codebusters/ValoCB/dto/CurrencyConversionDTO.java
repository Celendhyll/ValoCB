package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConversionDTO {

    /**
     * Currency that will be converted from.
     */
    private String currencyFrom;

    /**
     * Currency that will be converted to.
     */
    private String currencyTo;

    /**
     * Factor of the currency conversion from currencyFrom to currencyTo.
     */
    private BigDecimal conversionValue;

    /**
     * Constructor full for CurrencyConversion.
     * @param currencyFrom - the currency that will be converted from
     * @param currencyTo - the currency that will be converted to
     * @param conversionValue - the factor of conversion
     */
    public CurrencyConversionDTO(String currencyFrom, String currencyTo, BigDecimal conversionValue) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionValue = conversionValue;
    }
}
