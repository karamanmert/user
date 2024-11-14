package com.karamanmert.user.service.spec;

import com.karamanmert.user.entity.User;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
public interface UserService {

    User save(User user);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByEmail(String email);
}
