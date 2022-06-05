package com.wazooinc.springboottodoapplication.controllers;

import com.wazooinc.springboottodoapplication.models.TodoItem;
import com.wazooinc.springboottodoapplication.repositories.TodoItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoFormController {
    
    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    
        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }

    
}
