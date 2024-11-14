package com.karamanmert.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Builder
public record AddressDto(
        @JsonProperty("address")
        String customAddress
) {
}
