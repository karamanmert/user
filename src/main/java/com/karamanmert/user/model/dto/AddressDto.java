package com.karamanmert.user.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Builder
public record AddressDto(
        @JsonProperty("title")
        String title,

        @JsonProperty("city")
        String city,

        @JsonProperty("district")
        String district,

        @JsonProperty("neighborhood")
        String neighborhood,

        @JsonProperty("street")
        String street,

        @JsonProperty("address_id")
        String addressId,

        @JsonProperty("custom_address")
        String customAddress
) {
}
