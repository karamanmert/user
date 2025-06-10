package com.karamanmert.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

/**
 * @author karamanmert
 */
@Builder
public record GetUserInfoDto(
        @JsonProperty("user") UserDto user,
        @JsonProperty("addresses") List<AddressDto> addresses
) {
}
