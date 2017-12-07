package com.example.practice101.web.controller;

import com.example.practice101.model.Todo;
import com.example.practice101.repository.TodoDao;
import com.example.practice101.repository.UserDao;
import com.example.practice101.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    UserDao users;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos",todoService.findAll());
        return "index";
    }

    @RequestMapping(value="/todo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @RequestMapping(value="/complete", method = RequestMethod.POST)
    public String completeTodo(@RequestParam Long id) {
        todoService.toggleComplete(id);
        return "redirect:/";
    }

    @RequestMapping(value="/todo/{id}/delete", method = RequestMethod.POST)
    public String deleteTodo(@PathVariable Long id) {
        todoService.delete(todoService.findOne(id));
        return "redirect:/";
    }

}
