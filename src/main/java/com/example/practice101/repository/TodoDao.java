package com.example.practice101.repository;

import com.example.practice101.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo, Long> {
}
