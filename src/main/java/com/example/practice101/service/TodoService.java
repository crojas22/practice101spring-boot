package com.example.practice101.service;

import com.example.practice101.model.Todo;

public interface TodoService {

    void toggleComplete(Long id);
    Iterable<Todo> findAll();
    Todo findOne(Long id);
    void save(Todo todo);
    void delete(Todo todo);
}
