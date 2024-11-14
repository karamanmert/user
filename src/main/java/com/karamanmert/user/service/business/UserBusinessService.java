package com.karamanmert.user.service.business;

import com.karamanmert.user.entity.User;
import com.karamanmert.user.model.dto.UserDto;
import com.karamanmert.user.model.request.CreateUserRequest;
import com.karamanmert.user.service.spec.CustomUserMapper;
import com.karamanmert.user.service.spec.UserService;
import com.karamanmert.user.service.spec.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
@Service
@RequiredArgsConstructor
public class UserBusinessService {

    private final UserService userService;
    private final Validator<User> userValidator;
    private final CustomUserMapper customUserMapper;

    public UserDto createUser(CreateUserRequest request) {
        User user = customUserMapper.mapRequestToEntity(request);
        userValidator.isValidForCreate(user);
        userService.save(user);
        return customUserMapper.mapEntityToDto(user);
    }

    public void updateUser(User user) {
        userValidator.isValidForUpdate(user);
        userService.save(user);
    }

    public User getByEmail(String email) {
        return userService.findByEmail(email);
    }
}
