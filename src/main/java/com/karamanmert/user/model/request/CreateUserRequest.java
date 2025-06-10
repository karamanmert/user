package com.karamanmert.user.model.request;

import com.karamanmert.user.enums.GenderType;
import com.karamanmert.user.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

/**
 * @author karamanmert
 * @date 8.11.2024
 */

@Builder
public record CreateUserRequest(

        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(min = 2, max = 100, message = "INVALID_LENGTH")
        String name,

        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(min = 2, max = 100, message = "INVALID_LENGTH")
        String surname,

        // TODO: Add password annotation to provide a strong password
        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(min = 2, max = 30, message = "INVALID_LENGTH")
        String password,

        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(max = 10, message = "INVALID_LENGTH")
        String phoneNumber,

        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(max = 150, message = "INVALID_LENGTH")
        String email,

        @NotNull(message = "PARAMETER_REQUIRED")
        @Past(message = "INVALID_DATE_OF_BIRTH")
        LocalDate dateOfBirth,

        @NotNull(message = "PARAMETER_REQUIRED")
        GenderType gender,

        @NotNull(message = "PARAMETER_REQUIRED")
        UserRole role
) {
}
