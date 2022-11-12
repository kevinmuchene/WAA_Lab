package com.example.labs.domain.dto.response;


import com.example.labs.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String userName;
    private String firstName;
    private String lastName;

    private List<Role> listOfRoles;
}
