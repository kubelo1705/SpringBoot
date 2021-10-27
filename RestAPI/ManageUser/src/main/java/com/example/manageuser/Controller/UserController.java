package com.example.manageuser.Controller;

import com.example.manageuser.Entity.User;
import com.example.manageuser.Model.Dto.UserDto;
import com.example.manageuser.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users=userService.getListUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto user= userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(required = false) String name){
        List<UserDto> users=userService.searchUser(name);
        return ResponseEntity.ok(users);
    }

    @PostMapping("")
    public ResponseEntity<?> createUSer(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(){
        return null;
    }
}