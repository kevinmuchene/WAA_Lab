package com.example.labs.service.impl;

import com.example.labs.aspect.ExecutionTime;
import com.example.labs.domain.Post;
import com.example.labs.domain.User;
import com.example.labs.domain.dto.response.UserDto;
import com.example.labs.repo.UserRepo;
import com.example.labs.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {

        var users = userRepo.findAll();
        return users
                .stream()
                .map(p -> modelMapper.map(p, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @ExecutionTime
    public UserDto findById(int id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void save(UserDto userdto) {
        userRepo.save(modelMapper.map(userdto, User.class));
    }

    @Override
    public void addPost(Integer user_id, Post post) {
       User u = userRepo.findById(user_id).isPresent() ?  userRepo.findById(user_id).get() : null;
        assert u != null;
        List<Post> posts = u.getPosts();
       posts.add(post);
       userRepo.save(u);
    }

    @Override
    public List<Post> getPosts(Integer user_id) {
        return userRepo.findById(user_id).isPresent() ? userRepo.findById(user_id).get().getPosts() : null;
    }

    @Override
    //Use query here
    public List<User> getUsersWithMoreThanOnePost() {
        return userRepo.findAll().stream().filter(post -> post.getPosts().size() > 1).collect(Collectors.toList());
    }


}
