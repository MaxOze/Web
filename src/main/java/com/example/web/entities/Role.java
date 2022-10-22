package com.example.web.entities;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer role_id;
    private String name;

    public Integer getId() {
        return role_id;
    }

    public void setId(Integer id) {
        this.role_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
