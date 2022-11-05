package com.example.labs.service;

import com.example.labs.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    void saveComments(Integer post_id, Comment comment);

    List<Comment> getCommentsOfOnePost(Integer post_id);
}
