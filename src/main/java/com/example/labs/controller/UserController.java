package com.example.labs.controller;

import com.example.labs.domain.User;
import com.example.labs.domain.dto.response.UserDto;
import com.example.labs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/v1/users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/users/{id}")
    public UserDto getUsers(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("/v1/users")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping
    public void deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
    }

}
