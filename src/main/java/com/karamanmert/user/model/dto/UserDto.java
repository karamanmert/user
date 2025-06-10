package com.karamanmert.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.karamanmert.user.enums.GenderType;
import com.karamanmert.user.enums.UserRole;
import com.karamanmert.user.enums.UserStatus;
import lombok.Builder;

import java.time.LocalDate;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
@Builder
public record UserDto(
        @JsonProperty("user_id") String userId,
        @JsonProperty("name") String name,
        @JsonProperty("surname") String surname,
        @JsonProperty("username") String username,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("email") String email,
        @JsonProperty("date_of_birth") LocalDate dateOfBirth,
        @JsonProperty("status") UserStatus status,
        @JsonProperty("gender") GenderType gender,
        @JsonProperty("role") UserRole role
) {
}