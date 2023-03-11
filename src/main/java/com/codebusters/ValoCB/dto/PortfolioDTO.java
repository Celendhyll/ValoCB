package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO for the portfolio.
 */
@Data
@NoArgsConstructor
public class PortfolioDTO {

    /**
     * Name of the portfolio.
     */
    String name;

    /**
     * Products of the portfolio.
     */
    List<ProductDTO> products;

    /**
     * Constructor with name.
     * @param name - name of the portfolio
     */
    public PortfolioDTO(String name) {
        this.name = name;
    }

    /**
     * Getter for the list of products, initializes it if it is null.
     * @return the list of products
     */
    public List<ProductDTO> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}
