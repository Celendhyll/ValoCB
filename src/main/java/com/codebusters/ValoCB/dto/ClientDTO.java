package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * DTO for the client.
 */
@Data
@NoArgsConstructor
public class ClientDTO {

    /**
     * Name of the client.
     */
    private String name;

    /**
     * Map of the products and their quantity that the client possess.
     */
    private Map<ProductDTO, Long> productQuantityMap;

    /**
     * Ctor with name.
     * @param name - name of the client
     */
    public ClientDTO(String name) {
        this.name = name;
    }

    /**
     * Getter for the productQuantity map, initializes it if the map is null.
     * @return the productQuantity map
     */
    public Map<ProductDTO, Long> getProductQuantityMap() {
        if (productQuantityMap == null) {
            productQuantityMap = new HashMap<>();
        }
        return productQuantityMap;
    }
}
