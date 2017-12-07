package com.example.practice101.web.controller;

import com.example.practice101.model.Todo;
import com.example.practice101.model.User;
import com.example.practice101.repository.TodoDao;
import com.example.practice101.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {

    @Autowired
    TodoDao todoDao;

    @Autowired
    UserDao users;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("todos",todoDao.findAll());
        return "index";
    }

    @RequestMapping(value="/todo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute Todo todo) {
        todoDao.save(todo);
        return "redirect:/";
    }

    @RequestMapping(value="/complete", method = RequestMethod.POST)
    public String completeTodo(@RequestParam Long id) {
        Todo todo = todoDao.findOne(id);
        todo.setComplete(!todo.isComplete());
        todoDao.save(todo);
        return "redirect:/";
    }

}
