package com.example.web.repos;

import com.example.web.entities.Usr;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<Usr, Integer> {

    Optional<Usr> findByLogin(String login);

    Optional<Usr> findByFirstname(String name);
}
