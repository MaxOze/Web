package com.example.web.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cart_id;
    private String userName;
    @ManyToMany
    private List<Book> books_id;

    public Cart() { }

    public Cart(String usr_name, List<Book> books_id) {
        this.userName = usr_name;
        this.books_id = books_id;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String  usr_name) {
        this.userName = usr_name;
    }

    public List<Book> getBooks_id() {
        return books_id;
    }

    public void setBooks_id(List<Book> books_id) {
        this.books_id = books_id;
    }
}
