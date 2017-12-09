package com.example.practice101.model;

import javax.persistence.*;

@Entity
public class Todo extends BaseEntity {

    private String description;
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo() {
        super();
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
