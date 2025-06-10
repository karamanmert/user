package com.karamanmert.user.service.impl;

import com.karamanmert.common_lib.enums.ErrorCode;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.exception.ApiException;
import com.karamanmert.user.repository.UserRepository;
import com.karamanmert.user.service.spec.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 8.11.2024
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ErrorCode.USER_NOT_FOUND));
    }
}
