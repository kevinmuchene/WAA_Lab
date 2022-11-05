package com.example.labs.service.impl;

import com.example.labs.domain.Comment;
import com.example.labs.repo.CommentRepo;
import com.example.labs.repo.PostRepo;
import com.example.labs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;
    @Override
    public void saveComments(Integer post_id, Comment comment) {
        postRepo.findById(post_id).get().getComments().add(comment);
    }

    @Override
    public List<Comment> getCommentsOfOnePost(Integer post_id) {
        return postRepo.findById(post_id).get().getComments();
    }
}
