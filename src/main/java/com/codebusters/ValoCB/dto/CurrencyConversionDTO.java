package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConversionDTO {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionValue;

    public CurrencyConversionDTO(String currencyFrom, String currencyTo, BigDecimal conversionValue) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionValue = conversionValue;
    }
}
