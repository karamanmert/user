package com.karamanmert.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * @author karamanmert
 */
@Builder
public record UpdateAddressRequest(
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
