package com.example.labs.service;


import com.example.labs.domain.Post;
import com.example.labs.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {

    public List<PostDto> findAll();

    public PostDto findById(int id);

    public void deleteById(int id);

    public void save(PostDto postDto);

//    public void update(int id, PostDto postDto);


}
