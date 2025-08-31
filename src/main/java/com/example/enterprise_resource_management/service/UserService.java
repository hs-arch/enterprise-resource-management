package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import com.example.enterprise_resource_management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
//    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    User updateUser(Long id, UserRequestDTO dto);
    User deleteUser(Long id);
    User getUserById(Long id);
    User getUserByName(String name);
//    UserResponseDTO updateUserById(Long id, User userDetails);
}
