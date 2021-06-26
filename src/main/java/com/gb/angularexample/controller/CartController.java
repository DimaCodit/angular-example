package com.gb.angularexample.controller;

import com.gb.angularexample.dto.CartDto;
import com.gb.angularexample.service.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;

    @GetMapping
    public CartDto getCart(Principal principal) {
        return cart.getDto();
    }

    @PutMapping("/add/{id}")
    public void addItem(@PathVariable(name = "id") Long productId) {
        cart.addItem(productId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable(name = "id") Long productId) {
        cart.deleteItem(productId);
    }

    @GetMapping("/clear")
    public void clear() {
        cart.clear();
    }
}
