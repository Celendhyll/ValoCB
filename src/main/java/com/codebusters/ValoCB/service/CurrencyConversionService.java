package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import com.codebusters.ValoCB.dto.CurrencyConversionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Service used to handle operations related to CurrencyConversion.
 */
@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    /**
     * {@inheritDoc}
     */
    public BigDecimal getCurrencyFactor(String currencyFrom, String currencyTo) throws RuntimeException {
        // No need to do any calculus if from and to are the same currencies : return a factor one
        if (currencyFrom.equals(currencyTo)) {
            return BigDecimal.ONE;
        }
        Datas datas = Datas.getInstance();
        // In cas we find a conversion in our conversion list but the from and to are reversed
        // We want the inverse of the factor (conversionValue) found
        // In case of a division with infinite scale we will truncate to a scale of 4 and a half-even rounding mode
        Optional<BigDecimal> optFactor =
                datas.getCurrencyConversions().stream().filter(cc ->
                                (cc.getCurrencyFrom().equals(currencyFrom) && cc.getCurrencyTo().equals(currencyTo)) ||
                                        (cc.getCurrencyFrom().equals(currencyTo) && cc.getCurrencyTo().equals(currencyFrom)))
                        .findAny().map(cc -> cc.getCurrencyFrom().equals(currencyFrom) ? cc.getConversionValue() :
                                BigDecimal.ONE.divide(cc.getConversionValue(), 4, RoundingMode.HALF_EVEN).stripTrailingZeros());

        if (optFactor.isPresent()) {
            return optFactor.get();
        } else {
            String msg = String.format("Currency conversion not found between %1s and %2s", currencyFrom, currencyTo);
            throw new RuntimeException(msg);
        }
    }
}
