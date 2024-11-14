package com.karamanmert.user.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public record CreateAddressRequest(
        @NotBlank(message = "PARAMETER_REQUIRED")
        @Size(max = 500, message = "INVALID_LENGTH")
        String customAddress
) {
}
