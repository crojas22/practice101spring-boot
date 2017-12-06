package com.example.practice101.repository;

import com.example.practice101.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
