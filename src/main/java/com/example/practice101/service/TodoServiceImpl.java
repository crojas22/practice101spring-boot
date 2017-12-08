package com.example.practice101.service;

import com.example.practice101.model.Todo;
import com.example.practice101.repository.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoDao todoDao;

    @Override
    public void toggleComplete(Long id) {
        Todo todo = todoDao.findOne(id);
        todo.setComplete(!todo.isComplete());
        todoDao.save(todo);
    }

    @Override
    public Iterable<Todo> findAll() {
        return todoDao.findAll();
    }

    @Override
    public Todo findOne(Long id) {
        return todoDao.findOne(id);
    }

    @Override
    public void save(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoDao.delete(todo);
    }
}
