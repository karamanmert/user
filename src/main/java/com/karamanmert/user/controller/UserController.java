package com.karamanmert.user.controller;

import com.karamanmert.user.model.dto.GetUserInfoDto;
import com.karamanmert.user.model.dto.UserDto;
import com.karamanmert.user.model.request.CreateUserRequest;
import com.karamanmert.user.service.business.UserBusinessService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserBusinessService userBusinessService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userBusinessService.createUser(request));
    }

    @GetMapping("{email}")
    public ResponseEntity<GetUserInfoDto> getUserByEmail(@Valid @PathVariable @NotBlank(message = "PARAMETER_REQUIRED") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userBusinessService.getUserInfo(email));
    }
}
