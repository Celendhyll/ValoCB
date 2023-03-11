package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ProductDTO;
import com.codebusters.ValoCB.dto.UnderlyingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService implements IProductService {

    @Autowired
    IUnderlyingService underlyingService;

    public BigDecimal getProductPrice(ProductDTO product, String currency) throws RuntimeException {
        try {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (UnderlyingDTO u : product.getUnderlyings()) {
                totalPrice = totalPrice.add(underlyingService.getUnderlyingPrice(u, currency));
            }
            return totalPrice;
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the price of the product %1s: %2s", product.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
