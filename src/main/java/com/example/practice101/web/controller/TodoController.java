package com.example.practice101.web.controller;

import com.example.practice101.model.Todo;
import com.example.practice101.model.User;
import com.example.practice101.service.TodoService;
import com.example.practice101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    UserService users;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos",todoService.findAll());
        return "index";
    }

    @RequestMapping(value="/todo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute Todo todo, Principal principal) {
        // hitting server to check info
//        User user = users.findByUsername(principal.getName());
        // without using server
        User user = (User) ((UsernamePasswordAuthenticationToken)principal).getPrincipal();
        todo.setUser(user);
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
