package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ProductDTO;
import java.math.BigDecimal;

/**
 * Interface used to handle operations related to Product.
 */
public interface IProductService {

    /**
     * Get the price of a wanted product in the wanted currency.
     * @param product - the wanted product
     * @param currency - the wanted currency
     * @return the price of the product
     * @throws RuntimeException - in case of an error with the calculus
     */
    BigDecimal getProductPrice(ProductDTO product, String currency) throws RuntimeException;
}
