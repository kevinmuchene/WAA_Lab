package com.example.labs.repo.impl;

import com.example.labs.domain.Post;
import com.example.labs.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;

    private static int postId = 100;

    static {
        posts = new ArrayList<>();

        Post[] arrayOfPosts = {
                new Post(85, "IoT", "Learn IoT with the best", "Master IoT"),
                new Post(88, "Spring", "Learn Spring with the best", "Master Spring"),
                new Post(91, "Cloud", "Learn Cloud with the best", "Master Cloud"),
                new Post(95, "React", "Learn React with the best", "Master React"),
                new Post(99, "Containerization", "Learn Containerization with the best", "Master Docker")};


        Collections.addAll(posts, arrayOfPosts);
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        var post = posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();

        posts.remove(post);
    }

    @Override
    public void save(Post post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void update(int id, Post post) {


//        posts.add(id, post);

        deleteById(id);

        post.setId(id);
        posts.add(post);




    }
}
