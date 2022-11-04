package com.example.labs.repo;

import com.example.labs.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

//    public List<Post> findAll();
//
//    public Post findById(int id);
//
//    public void deleteById(int id);
//
//    public void update(int id, Post post);


}
