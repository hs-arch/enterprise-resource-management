package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.UserRequestDTO;
import com.example.enterprise_resource_management.dto.UserResponseDTO;
import com.example.enterprise_resource_management.entity.User;
import com.example.enterprise_resource_management.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.enterprise_resource_management.entity.User.Role;

import java.util.List;
import java.util.Optional;

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
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else {
            throw new EntityNotFoundException("User with id " + id + " not found.");
        }
    }

    public User getUserByName(String name){
        Optional<User> optionalUser = userRepository.findByUsername(name);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new EntityNotFoundException("User with name " + name + " not found.");
        }
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
    public User updateUser(Long id, UserRequestDTO dto) {

        String fullname = dto.getFullName();
        String email = dto.getEmail();
        String username = dto.getUsername();
        String role = dto.getRole();
        String password = dto.getPassword();

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            optionalUser.get().setRole(Role.valueOf(role));
            optionalUser.get().setEmail(email);
            optionalUser.get().setFull_name(fullname);
            optionalUser.get().setUsername(username);
            optionalUser.get().setPassword_hash(password);
        }else{
            throw new EntityNotFoundException("User not found");
        }

        userRepository.save(optionalUser.get());
        return null;
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return optionalUser.get();
        }else{
            throw new EntityNotFoundException("No such user with id : " + id + " exists.");
        }
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
