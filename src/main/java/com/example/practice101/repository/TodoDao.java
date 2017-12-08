package com.example.practice101.repository;

import com.example.practice101.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoDao extends CrudRepository<Todo, Long> {
    @Query("select t from Todo t where t.user.id=:#{principal.id}")
    List<Todo> findAll();
}
