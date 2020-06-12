package com.cinema.model.mapper.impl;

import com.cinema.model.User;
import com.cinema.model.dto.request.UserRequestDto;
import com.cinema.model.dto.response.UserResponseDto;
import com.cinema.model.mapper.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements ItemMapper<User, UserRequestDto, UserResponseDto> {
    @Override
    public User toEntity(UserRequestDto dto) {
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    @Override
    public UserResponseDto toDto(User entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        return dto;
    }
}
