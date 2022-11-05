package com.example.labs.service;

import com.example.labs.domain.Post;
import com.example.labs.domain.User;
import com.example.labs.domain.dto.response.PostDto;
import com.example.labs.domain.dto.response.UserDto;


import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(int id);

    void deleteById(int id);

    void save(UserDto Userdto);

    void addPost(Integer user_id, Post post);

    List<Post> getPosts(Integer user_id);

    List<User> getUsersWithMoreThanOnePost();
}
