package com.example.labs.controller;

import com.example.labs.domain.Comment;
import com.example.labs.domain.Post;
import com.example.labs.domain.User;
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


    @DeleteMapping("/v1/posts/{id}")
    public void deleteById(@PathVariable("id") int id) {
       postService.deleteById(id);
    }

    @DeleteMapping("/v2/posts/{id}")
    public void deleteByIdVersion2(@PathVariable("id") int id) {
        postService.deleteById(id);
    }


    @PostMapping("/v1/posts/{post_id}/comments")
    public void savePostComments(@PathVariable("post_id") Integer post_id, @RequestBody Comment comment) {

       postService.saveComments(post_id, comment);

    }

    @GetMapping("/v1/usersnpost/{id}/posts")
    public List<User> withMoreThanNPosts(@PathVariable("id") int id) {
       return postService.getUsersWithMoreThanNPosts(id);
    }

    @GetMapping("/v1/postmatchingtitles/{title}")
    public List<Post> postMatchingTitle(@PathVariable("title") String title) {
       return postService.getPostMatchingTitle(title);
    }

}
