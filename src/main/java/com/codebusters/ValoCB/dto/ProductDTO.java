package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private List<UnderlyingDTO> underlyings;

    public ProductDTO(String name) {
        this.name = name;
    }

    public List<UnderlyingDTO> getUnderlyings() {
        if (underlyings == null) {
            underlyings = new ArrayList<>();
        }
        return underlyings;
    }
}
