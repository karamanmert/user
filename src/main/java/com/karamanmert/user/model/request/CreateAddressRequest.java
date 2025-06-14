package com.karamanmert.user.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public record CreateAddressRequest(
        @NotBlank(message = "PARAMETER_REQUIRED")
        String city,

        @NotBlank(message = "PARAMETER_REQUIRED")
        String district,

        @NotBlank(message = "PARAMETER_REQUIRED")
        String title,

        @NotBlank(message = "PARAMETER_REQUIRED")
        String neighborhood,

        @NotBlank(message = "PARAMETER_REQUIRED")
        String street,

        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(max = 500, message = "INVALID_LENGTH")
        String customAddress
) {
}
