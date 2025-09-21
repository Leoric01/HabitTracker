package com.leoric.habit.services;

import com.leoric.habit.dto.request.UserRequestDto;
import com.leoric.habit.dto.response.UserResponseDto;
import com.leoric.habit.models.User;
import com.leoric.habit.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    private UserResponseDto mapToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    @Override
    public List<UserResponseDto> findAll() {
        return repository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public UserResponseDto findById(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        User saved = repository.save(user);
        return mapToDto(saved);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(dto.getUsername());

        User saved = repository.save(user);
        return mapToDto(saved);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}