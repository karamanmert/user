package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.User;
import com.karamanmert.user.enums.UserStatus;
import com.karamanmert.user.model.dto.UserDto;
import com.karamanmert.user.model.request.CreateUserRequest;
import com.karamanmert.user.service.spec.CustomUserMapper;
import org.springframework.stereotype.Component;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Component
public class CustomUserMapperImpl implements CustomUserMapper {

    @Override
    public User mapRequestToEntity(CreateUserRequest request) {
        if (request == null) {
            return null;
        }
        return User.builder()
                .name(request.name())
                .surname(request.surname())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .gender(request.gender())
                .role(request.role())
                .status(UserStatus.ACTIVE)
                .build();
    }

    @Override
    public UserDto mapEntityToDto(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .surname(user.getSurname())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.getGender())
                .status(UserStatus.ACTIVE)
                .role(user.getRole())
                .build();
    }
}
