package com.example.labs.service.impl;

import com.example.labs.aspect.ExecutionTime;
import com.example.labs.domain.Post;
import com.example.labs.domain.Role;
import com.example.labs.domain.User;
import com.example.labs.domain.dto.request.AuthRequest;
import com.example.labs.domain.dto.response.UserDto;
import com.example.labs.repo.UserRepo;
import com.example.labs.service.UserService;
import com.example.labs.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

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
    public void save(User user) {
        userRepo.save(user);
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

    @Override
    public String generateToken(AuthRequest authRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch(Exception ex){
            throw new Exception("invalid username/password");
        }

        return jwtUtil.generateToken(authRequest.getUserName());
    }

    @Override
    public void saveUserRole(Integer user_id, Role role) {
        if(user_id == null || role == null) {
            return;
        }

//        findById(user_id).getListOfRoles().add(role);

        var user = userRepo.findById(user_id).get();


        user.getRoles().add(role);

        System.out.println(listOfUsers().toString());

//            save(user);


    }

    public List<User> listOfUsers() {
        return userRepo.findAll();
    }


}
