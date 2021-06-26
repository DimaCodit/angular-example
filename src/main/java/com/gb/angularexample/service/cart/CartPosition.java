package com.gb.angularexample.service.cart;

import com.gb.angularexample.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartPosition {

    private ProductDto product;
    private Integer quantity = 0;
    private Integer price = 0;
    private Integer sum = 0;

    public void calcSum() {
        sum = quantity * price;
    }

    public CartPosition(ProductDto product, Integer quantity, Integer price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.sum = quantity * price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.sum = this.quantity * this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
        this.sum = this.quantity * this.price;
    }
}
