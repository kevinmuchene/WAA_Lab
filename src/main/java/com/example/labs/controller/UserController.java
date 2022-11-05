package com.example.labs.controller;

import com.example.labs.domain.Post;
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

    @PostMapping("/v1/users/{user_id}/posts")
    public void addPost(@PathVariable("user_id") Integer user_id,@RequestBody Post post ){
        userService.addPost(user_id,post);
    }

    @GetMapping("/v1/users/{user_id}/posts")
    public List<Post> getPosts(@PathVariable("user_id") Integer user_id){
        return userService.getPosts(user_id);
    }

    @GetMapping("/v1/postsMoreThanOne")
    public List<User> withMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost();
    }
}
