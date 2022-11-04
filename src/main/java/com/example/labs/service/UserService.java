package com.example.labs.service;

import com.example.labs.domain.dto.response.PostDto;
import com.example.labs.domain.dto.response.UserDto;


import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    public UserDto findById(int id);

    public void deleteById(int id);

    public void save(UserDto Userdto);
}
