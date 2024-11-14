package com.karamanmert.user.service.spec;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface CustomAddressMapper {

    Address mapCreateRequestToEntity(CreateAddressRequest createAddressRequest);

    AddressDto mapEntityToDto(Address address);
}
