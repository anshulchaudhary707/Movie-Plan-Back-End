package com.example.movieplan.service;

import com.example.movieplan.dto.CartDto;
import com.example.movieplan.model.Cart;
import com.example.movieplan.model.Shows;
import com.example.movieplan.model.User;
import com.example.movieplan.repository.CartRepository;
import com.example.movieplan.repository.ShowsRepository;
import com.example.movieplan.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired private ShowsRepository showsRepository;
    @Autowired private CartRepository cartRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ModelMapper modelMapper;
    @Override
    public Cart addToCart(long showId) {
        Shows shows = this.showsRepository.searchShowsByShowId(showId);
        Cart cart = this.cartRepository.getCartDetails(this.userRepository.searchUserByEmail("anshul@gmail.com"),this.showsRepository.searchShowsByShowId(showId));
        if(cart == null){
            cart = new Cart();
            cart.setQuantity(1);
            cart.setDate(shows.getDate());
            cart.setTime(shows.getTime());
            cart.setShow(shows);
            cart.setTheatreId(shows.getUser().getEmail());
            cart.setTheatreAddress(shows.getUser().getAddress());
            cart.setTheatreName(shows.getUser().getName());
            User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
            cart.setUser(user);
        }else{
            cart.setQuantity(cart.getQuantity()+1);
        }
        return this.cartRepository.save(cart);
    }
    @Override
    public Cart increaseQuantity(long cartId) {
        Cart cart = this.cartRepository.getCartByCartId(cartId);
        cart.setQuantity(cart.getQuantity()+1);
        return this.cartRepository.save(cart);
    }
    @Override
    public void deleteItem(long cartId) {
        Cart cart = this.cartRepository.getCartByCartId(cartId);
        this.cartRepository.delete(cart);
    }
    @Override
    public List<CartDto> viewCart() {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.searchCartByUser(user);
        List<CartDto> list1 = new ArrayList<>();
        for(Cart cart : list){
            if(cart.getDate().toLocalDate().isEqual(LocalDate.now()) && cart.getTime().toLocalTime().isBefore(LocalTime.now())){
                this.cartRepository.delete(cart);
            }
            else{
                CartDto cartDto = this.modelMapper.map(cart,CartDto.class);
                cartDto.setMovieName(cart.getShow().getMovieName());
                cartDto.setDate(cart.getDate().toString());
                cartDto.setTime(cart.getTime().toString());
                cartDto.setNameOfCustomer(user.getName());
                list1.add(cartDto);
            }
        }
        return list1;
    }
    @Override
    public void emptyCart() {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.searchCartByUser(user);
        for(Cart cart : list){
            this.cartRepository.delete(cart);
        }
    }
}
