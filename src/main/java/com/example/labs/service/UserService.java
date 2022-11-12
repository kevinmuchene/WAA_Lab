package com.example.labs.service;

import com.example.labs.domain.Post;
import com.example.labs.domain.Role;
import com.example.labs.domain.User;
import com.example.labs.domain.dto.request.AuthRequest;
import com.example.labs.domain.dto.response.PostDto;
import com.example.labs.domain.dto.response.UserDto;


import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(int id);

    void deleteById(int id);

    void save(User User);

    void addPost(Integer user_id, Post post);

    List<Post> getPosts(Integer user_id);

    List<User> getUsersWithMoreThanOnePost();

    String generateToken(AuthRequest authRequest) throws Exception;

    void saveUserRole(Integer user_id, Role role);
}
