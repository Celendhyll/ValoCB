package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PortfolioDTO {
    String name;
    List<ProductDTO> products;

    public PortfolioDTO(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
}
