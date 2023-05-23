package com.spring.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.spring.test.service.TodoService;
import com.spring.test.data.model.Todo;

@Controller
@RequestMapping("/")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index(Model model) {
        List<Todo> todoList = todoService.retrieveAllTodo();
        model.addAttribute("todoList", todoList);
        return "todo/index";
    }

    @PostMapping("/create")
    public String addTodo(@RequestParam("title") String title) {
        todoService.createTodo(new Todo(title));
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTodoState(@PathVariable Long id) {
        todoService.toggleTodoState(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
}
