package com.example.movieplan.controller;

import com.example.movieplan.dto.CartDto;
import com.example.movieplan.model.Cart;
import com.example.movieplan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/normal")
public class CartController {
    @Autowired private CartService cartService;
    @GetMapping("/add/to/cart/{showId}")
    public ResponseEntity<String> addToCart(@PathVariable("showId") long showId){
        Cart cart = this.cartService.addToCart(showId);
        if(cart == null){
            return new ResponseEntity<String>("Item not added to Cart.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Item added to Cart.", HttpStatus.OK);
    }
    @GetMapping("/increase/quantity/{cartId}")
    public ResponseEntity<String> increaseQuantity(@PathVariable("cartId") long cartId){
        Cart cart = this.cartService.increaseQuantity(cartId);
        if(cart == null){
            return new ResponseEntity<String>("Quantity not Increased.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Quantity Increased.", HttpStatus.OK);
    }
    @GetMapping("/delete/item/{cartId}")
    public ResponseEntity<String> deleteItem(@PathVariable("cartId") long cartId){
        this.cartService.deleteItem(cartId);
        return new ResponseEntity<String>("Item deleted from Cart.", HttpStatus.OK);
    }
    @GetMapping("/view/cart")
    public ResponseEntity<List<CartDto>> viewCart(){
        return new ResponseEntity<List<CartDto>>(this.cartService.viewCart(),HttpStatus.OK);
    }
    @GetMapping("/empty/cart")
    public ResponseEntity<String> emptyCart(){
        this.cartService.emptyCart();
        return new ResponseEntity<String>("Cart emptied.", HttpStatus.OK);
    }
}
