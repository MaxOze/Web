package com.example.web.repos;

import com.example.web.entities.Book;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Integer> {

    List<Book> findAll(Pageable pageable);

    Optional<Book> findById(Integer id);

    void deleteById(Integer id);
}
