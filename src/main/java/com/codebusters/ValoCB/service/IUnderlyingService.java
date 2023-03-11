package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.UnderlyingDTO;

import java.math.BigDecimal;

@FunctionalInterface
public interface IUnderlyingService {
    BigDecimal getUnderlyingPrice(UnderlyingDTO underlying, String currency) throws RuntimeException;
}
