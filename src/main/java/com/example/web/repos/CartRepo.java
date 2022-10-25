package com.example.web.repos;

import com.example.web.entities.Cart;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepo extends CrudRepository<Cart, Integer> {
    Optional<Cart> findByUserName(String name);
}
