package com.example.movieplan.service;

import com.example.movieplan.dto.CartDto;
import com.example.movieplan.model.Cart;

import java.util.List;

public interface CartService {
    Cart addToCart(long showId);
    Cart increaseQuantity(long cartId);
    void deleteItem(long cartId);
    List<CartDto> viewCart();
    void emptyCart();
}
