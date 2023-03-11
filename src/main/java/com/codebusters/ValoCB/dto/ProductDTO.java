package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for the product.
 */
@Data
@NoArgsConstructor
public class ProductDTO {

    /**
     * Name of the product.
     */
    private String name;

    /**
     * List of the underlyings of the product.
     */
    private List<UnderlyingDTO> underlyings;

    /**
     * Constructor with name.
     * @param name - name of the product
     */
    public ProductDTO(String name) {
        this.name = name;
    }

    /**
     * Getter for the list of underlyings, intializes it if it is null.
     * @return the list of underlyings
     */
    public List<UnderlyingDTO> getUnderlyings() {
        if (underlyings == null) {
            underlyings = new ArrayList<>();
        }
        return underlyings;
    }
}
