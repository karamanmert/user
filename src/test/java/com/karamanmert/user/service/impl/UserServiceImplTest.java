package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.User;
import com.karamanmert.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author karamanmert
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository repository;

    @Test
    void should_findByEmail() {
        // Given
        User user = new User();
        String email = "mert@test.com";
        when(repository.findByEmail(email))
                .thenReturn(Optional.of(user));

        // When
        User actual = this.userService.findByEmail(email);

        // Then
        verify(repository).findByEmail(email);
        assertNotNull(actual);
    }
}