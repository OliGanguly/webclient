package com.example.pragratask.controller;

import com.example.pragratask.Entity.User;
import com.example.pragratask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save/{name}")
    public  User createData(@RequestBody User user,@PathVariable String name){
        return userService.saveData(user,name);
    }
}
