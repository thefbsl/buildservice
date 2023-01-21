package com.arman.build.controllers;

import com.arman.build.models.User;
import com.arman.build.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService service;

    @PostMapping()
    public User createUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/get")
    public List<User> index(){
        return service.index();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return service.getById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        return service.delete(id);
    }

}
