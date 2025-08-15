package com.codewithmosh.store.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartProductDto implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
}