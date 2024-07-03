package com.example.controller;

import com.example.model.CartItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private List<CartItem> cartItems = new ArrayList<>();

    @GetMapping
    public List<CartItem> viewCart() {
        return cartItems;
    }

    @PostMapping
    public void addItemToCart(@RequestBody CartItem item) {
        cartItems.add(item);
    }

    @DeleteMapping("/{id}")
    public void removeItemFromCart(@PathVariable Long id) {
        cartItems.removeIf(item -> item.getId().equals(id));
    }
}
