package com.example.labs.repo;

import com.example.labs.domain.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();

    public Post findById(int id);

    public void deleteById(int id);

    public void save(Post post);

    public void update(int id, Post post);
}
