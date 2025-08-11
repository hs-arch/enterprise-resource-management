package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import com.example.enterprise_resource_management.entity.User;
import com.example.enterprise_resource_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {

        if(userRepository.existsByUsername(dto.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }

        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password_hash(dto.getPassword())
                .full_name(dto.getFullName())
                .role(User.Role.valueOf(dto.getRole()))
                .build();

        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);

    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(
                user -> new UserResponseDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getFull_name(),
                        user.getRole().name()
                        ))
                .toList();
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    private UserResponseDTO mapToResponseDTO(User user){

        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFull_name())
                .role(user.getRole().name())
                .build();
    }
}
