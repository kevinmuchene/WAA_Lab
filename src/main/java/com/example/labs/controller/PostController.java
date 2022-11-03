package com.example.labs.controller;

import com.example.labs.domain.dto.response.PostDto;
import com.example.labs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class PostController {

   @Autowired
   PostService postService;

   @GetMapping("/v1/posts")
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/v2/posts")
    public List<PostDto> getPostsVersion2() {
        return postService.findAll();
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/posts/{id}")
    public PostDto getPost(@PathVariable("id") int id) {
       return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v2/posts/{id}")
    public PostDto getPostVersion2(@PathVariable("id") int id) {
        return postService.findById(id);
    }

    @PostMapping("/v1/posts")
    public void save(@RequestBody PostDto postDto) {
       postService.save(postDto);
    }

    @PostMapping("/v2/posts")
    public void saveVersion2(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @DeleteMapping("/v1/posts/{id}")
    public void deleteById(@PathVariable("id") int id) {
       postService.deleteById(id);
    }

    @DeleteMapping("/v2/posts/{id}")
    public void deleteByIdVersion2(@PathVariable("id") int id) {
        postService.deleteById(id);
    }


    @PutMapping("/v1/posts/{id}")
    public void updateById(@PathVariable("id") int id, @RequestBody PostDto postDto) {
       postService.update(id, postDto);
    }

    @PutMapping("/v2/posts/{id}")
    public void updateByIdVersion2(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
    }
}
