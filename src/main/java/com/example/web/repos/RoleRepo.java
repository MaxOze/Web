package com.example.web.repos;

import com.example.web.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepo extends CrudRepository<Role, Integer> {

    Optional<Role> findById(Integer id);
}
