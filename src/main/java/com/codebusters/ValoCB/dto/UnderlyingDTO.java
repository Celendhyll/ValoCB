package com.codebusters.ValoCB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnderlyingDTO {
    private String name;
    private String currency;
    private Long price;


    public UnderlyingDTO(String name, String currency, Long price) {
        this.name = name;
        this.currency = currency;
        this.price = price;
    }
}
