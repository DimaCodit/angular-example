package com.gb.angularexample.dto;

import com.gb.angularexample.service.cart.CartPosition;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CartDto {

    private Integer totalSum;
    private List<CartPosition> positions;

    public CartDto(Integer totalSum, List<CartPosition> positions) {
        this.totalSum = totalSum;
        this.positions = positions;
    }
}