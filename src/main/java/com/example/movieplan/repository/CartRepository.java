package com.example.movieplan.repository;

import com.example.movieplan.model.Cart;
import com.example.movieplan.model.Shows;
import com.example.movieplan.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    Cart getCartByCartId(long cartId);
    @Query("Select c From Cart c Where c.show =:s AND c.user =:u")
    Cart getCartDetails(@Param("u") User user, @Param("s")Shows shows);
    List<Cart> searchCartByUser(User user);
}
