package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ClientDTO {
    private String name;
    private Map<ProductDTO, Long> productQuantityMap;

    public ClientDTO(String name) {
        this.name = name;
    }

    public Map<ProductDTO, Long> getProductQuantityMap() {
        if (productQuantityMap == null) {
            productQuantityMap = new HashMap<>();
        }
        return productQuantityMap;
    }
}
