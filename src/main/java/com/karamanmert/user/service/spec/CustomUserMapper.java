package com.karamanmert.user.service.spec;

import com.karamanmert.user.entity.User;
import com.karamanmert.user.model.dto.UserDto;
import com.karamanmert.user.model.request.CreateUserRequest;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface CustomUserMapper {

    User mapRequestToEntity(CreateUserRequest request);

    UserDto mapEntityToDto(User user);
}
