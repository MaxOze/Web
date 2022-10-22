package com.example.web.repos;

import com.example.web.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByLogin(String login);
}
