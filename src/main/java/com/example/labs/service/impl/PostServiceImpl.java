package com.example.labs.service.impl;

import com.example.labs.domain.Post;
import com.example.labs.domain.dto.response.PostDto;
import com.example.labs.repo.PostRepo;
import com.example.labs.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
//
        return posts
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void deleteById(int id) {
            postRepo.deleteById(id);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }



}
