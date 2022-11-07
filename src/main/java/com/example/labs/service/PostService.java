package com.example.labs.service;


import com.example.labs.domain.Comment;
import com.example.labs.domain.Post;
import com.example.labs.domain.User;
import com.example.labs.domain.dto.response.CommentDto;
import com.example.labs.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(int id);

    void deleteById(int id);

    void save(PostDto postDto);

    void saveComments(Integer id, Comment comment);

    List<User> getUsersWithMoreThanNPosts(int n);

    List<Post> getPostMatchingTitle(String title);
}
