package com.example.movieplan.repository;

import com.example.movieplan.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    User searchUserByEmail(String email);
    Optional<User> findByEmail(String email);
}
