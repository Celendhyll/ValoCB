package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ClientDTO;
import com.codebusters.ValoCB.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ClientService implements IClientService {

    @Autowired
    IProductService productService;

    /**
     * {@inheritDoc}
     */
    public BigDecimal getClientCapital(ClientDTO client, String currency) throws RuntimeException {
        try {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (Map.Entry<ProductDTO, Long> productQuantity : client.getProductQuantityMap().entrySet()) {
                totalPrice = totalPrice.add(productService.getProductPrice(productQuantity.getKey(), currency)
                        .multiply(BigDecimal.valueOf(productQuantity.getValue())));
            }
            return totalPrice.stripTrailingZeros();
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the capital of the client %1s: %2s", client.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
