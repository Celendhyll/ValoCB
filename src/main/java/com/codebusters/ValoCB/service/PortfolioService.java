package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.PortfolioDTO;
import com.codebusters.ValoCB.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service used to handle operations related to Portfolio.
 */
@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    IProductService productService;

    /**
     * {@inheritDoc}
     */
    public BigDecimal getPortfolioPrice(PortfolioDTO portfolio, String currency) throws RuntimeException {
        try {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (ProductDTO product : portfolio.getProducts()) {
                totalPrice = totalPrice.add(productService.getProductPrice(product, currency));
            }
            return totalPrice.stripTrailingZeros();
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the price of the portfolio %1s: %2s", portfolio.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
