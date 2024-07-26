package com.carloseduardo.todolist.controller;

import com.carloseduardo.todolist.entity.Todo;
import com.carloseduardo.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping("/list")
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping("/update")
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/delete/{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}
