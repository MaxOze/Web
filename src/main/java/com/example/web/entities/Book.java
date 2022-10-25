package com.example.web.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer book_id;
    private String name;
    private String author;
    private Integer price;

    public Book() { }

    public Book(String name, String author, Integer price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer id) {
        this.book_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
