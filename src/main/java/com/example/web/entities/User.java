package com.example.web.entities;

import javax.persistence.*;

@Entity
@Table(name="usr")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String email;
    private String login;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName="role_id")
    private Role role_name;

    public User() { }

    public User(String firstname, String email, String login, String password, Role role_name) {
        this.firstname = firstname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role_name = role_name;
    }

    public String getRoleName() {
        return role_name.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Role getRole() {
        return role_name;
    }

    public void setRole(Role role) {
        this.role_name = role;
    }
}
