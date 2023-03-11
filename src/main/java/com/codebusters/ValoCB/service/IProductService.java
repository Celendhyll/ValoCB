package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ProductDTO;

import java.math.BigDecimal;

@FunctionalInterface
public interface IProductService {
    BigDecimal getProductPrice(ProductDTO product, String currency) throws RuntimeException;
}
