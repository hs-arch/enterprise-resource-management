package com.example.enterprise_resource_management.controller;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import com.example.enterprise_resource_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userrequestDTO){
        return userService.createUser(userrequestDTO);
    }

}
