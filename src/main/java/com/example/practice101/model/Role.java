package com.example.practice101.model;

import javax.persistence.*;

@Entity
public class Role extends BaseEntity {

    private String name;

    public Role() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
