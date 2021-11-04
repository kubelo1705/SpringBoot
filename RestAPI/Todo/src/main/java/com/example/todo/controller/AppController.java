package com.example.todo.controller;

import com.example.todo.enity.Todo;
import com.example.todo.enity.TodoVadilator;
import com.example.todo.reponsitory.TodoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class AppController {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoVadilator todoVadilator;

    private Logger logger;

    @PostMapping("/add")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        if (todoVadilator.isValid(todo)) {
            todoRepository.save(todo);
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.badRequest().body("Unvalid value");
    }

    @GetMapping("")
    public ResponseEntity<?> getListTodo(){
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable String id){
        return ResponseEntity.ok(todoRepository.findById(Long.parseLong(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo, @PathVariable String id) {
        if (todoRepository.findById(Long.parseLong(id)).isPresent()) {
            return todoVadilator.isValid(todo) ? ResponseEntity.ok(todoRepository.save(todo)) : ResponseEntity.badRequest().body("Unvalid value");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id){
        if (todoRepository.findById(Long.parseLong(id)).isPresent()) {
                todoRepository.deleteById(Long.parseLong(id));
                return ResponseEntity.ok("Deleted");
            }else{
                return ResponseEntity.badRequest().body("Unvalid value");
            }
    }

}
