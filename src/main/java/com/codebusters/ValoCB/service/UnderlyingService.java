package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.UnderlyingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service used to handle operations related to Underlying.
 */
@Service
public class UnderlyingService implements IUnderlyingService {

    @Autowired
    ICurrencyConversionService currencyConversionService;

    /**
     * {@inheritDoc}
     */
    public BigDecimal getUnderlyingPrice(UnderlyingDTO underlying, String currency) throws RuntimeException {
        try {
            return BigDecimal.valueOf(underlying.getPrice()).multiply(
                    currencyConversionService.getCurrencyFactor(underlying.getCurrency(), currency));
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the price of the underlying %1s: %2s", underlying.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
