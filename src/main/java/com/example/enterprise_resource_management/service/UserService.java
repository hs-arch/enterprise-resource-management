package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO getUserById(Long id);
    Page<UserResponseDTO> getAllUsers(Pageable pageable);
    UserResponseDTO updateUser(Long id, UserRequestDTO dto);
    void deleteUser(Long id);
}
