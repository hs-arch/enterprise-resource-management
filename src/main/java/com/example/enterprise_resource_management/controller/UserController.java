package com.example.enterprise_resource_management.controller;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import com.example.enterprise_resource_management.entity.User;
import com.example.enterprise_resource_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
       List<UserResponseDTO> users = userService.getAllUsers();
       return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        System.out.println("Got the name till here : " + name);
        User user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody UserRequestDTO userDetails){
        System.out.println("User details : " + userDetails.toString());
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id){
        User user = userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }
}
