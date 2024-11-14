package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.spec.CustomAddressMapper;
import org.springframework.stereotype.Component;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Component
public class CustomAddressMapperImpl implements CustomAddressMapper {

    @Override
    public Address mapCreateRequestToEntity(CreateAddressRequest request) {
        if (request == null) {
            return null;
        }
        return Address.builder()
                .customAddress(request.customAddress())
                .build();
    }

    @Override
    public AddressDto mapEntityToDto(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDto.builder()
                .customAddress(address.getCustomAddress())
                .build();
    }
}
