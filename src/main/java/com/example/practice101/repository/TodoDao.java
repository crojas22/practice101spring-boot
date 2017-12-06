package com.example.practice101.repository;

import com.example.practice101.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo, Long> {
}
