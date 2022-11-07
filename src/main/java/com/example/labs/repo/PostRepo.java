package com.example.labs.repo;

import com.example.labs.domain.Post;
import com.example.labs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    @Query("select u from User u where u.posts.size > :n")
    List<User> userWithMoreThanNPost(int n);

    @Query("select post from Post post where post.title = :title")
    List<Post> getPostByTitleMatches(String title);
}
