package com.example.labs.repo;

import com.example.labs.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepo extends JpaRepository<Post, Integer> { }
