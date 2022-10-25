package com.example.web.entities;

import javax.persistence.*;
import java.util.List;

@Entity

public class BookOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer order_id;
    @ManyToOne
    private Usr usr_id;
    @ManyToMany
    private List<Book> books_id;
    private String order_date;

    public BookOrder() { }

    public BookOrder(Usr usr, List<Book> books, String date) {
        this.usr_id = usr;
        this.books_id = books;
        this.order_date = date;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer id) {
        this.order_id = id;
    }

    public Usr getUser() {
        return usr_id;
    }

    public void setUser(Usr usr) {
        this.usr_id = usr;
    }

    public List<Book> getBooks_id() {
        return books_id;
    }

    public void setBooks_id(List<Book> books) {
        this.books_id = books;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String date) {
        this.order_date = date;
    }
}
