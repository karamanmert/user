package com.karamanmert.user.service.spec;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.dto.UpdateAddressRequest;
import com.karamanmert.user.model.request.CreateAddressRequest;

import java.util.List;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface CustomAddressMapper {

    Address mapRequestToEntity(CreateAddressRequest request);

    AddressDto mapEntityToDto(Address address);

    List<AddressDto> mapEntityListToDtoList(List<Address> address);

    Address updateEntity(Address address, UpdateAddressRequest request);
}
