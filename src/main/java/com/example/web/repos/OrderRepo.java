package com.example.web.repos;

import com.example.web.entities.BookOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<BookOrder, Integer> {
}
