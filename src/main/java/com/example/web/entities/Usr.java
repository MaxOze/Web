package com.example.web.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Usr {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer usr_id;

    private String firstname;

    private String email;
    private String login;
    private String password;
    @ManyToOne
    private Role role_name;
    @OneToMany
    @JsonIgnoreProperties("user")
    private Set<BookOrder> orders;

    public Usr() { }

    public Usr(String firstname, String email, String login, String password, Role role_name) {
        this.firstname = firstname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role_name = role_name;
    }

    public String getRoleName() {
        return role_name.getName();
    }

    public Integer getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Integer id) {
        this.usr_id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole_name() {
        return role_name;
    }

    public void setRole_name(Role role_name) {
        this.role_name = role_name;
    }

    public Set<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<BookOrder> orders) {
        this.orders = orders;
    }
}
