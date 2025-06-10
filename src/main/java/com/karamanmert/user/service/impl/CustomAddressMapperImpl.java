package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.dto.UpdateAddressRequest;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.spec.CustomAddressMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Component
public class CustomAddressMapperImpl implements CustomAddressMapper {


    @Override
    public Address mapRequestToEntity(CreateAddressRequest request) {
        if (request == null) {
            return null;
        }

        return Address.builder()
                .city(request.city())
                .district(request.district())
                .neighborhood(request.neighborhood())
                .street(request.street())
                .title(request.title())
                .customAddress(request.customAddress())
                .build();
    }

    @Override
    public AddressDto mapEntityToDto(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDto.builder()
                .addressId(address.getAddressId())
                .city(address.getCity())
                .district(address.getDistrict())
                .neighborhood(address.getNeighborhood())
                .street(address.getStreet())
                .title(address.getTitle())
                .customAddress(address.getCustomAddress())
                .build();
    }

    @Override
    public List<AddressDto> mapEntityListToDtoList(List<Address> address) {
        if (address.isEmpty()) {
            return new ArrayList<>();
        }

        List<AddressDto> addressDtoList = new ArrayList<>();
        for (Address addressDto : address) {
            addressDtoList.add(mapEntityToDto(addressDto));
        }

        return addressDtoList;
    }

    @Override
    public Address updateEntity(Address address, UpdateAddressRequest request) {
        if (request == null) {
            return null;
        }

        if (address == null) {
            return null;
        }

        address.setTitle(request.title());
        address.setCustomAddress(request.customAddress());
        address.setDistrict(request.district());
        address.setNeighborhood(request.neighborhood());
        address.setStreet(request.street());
        address.setCity(request.city());
        return address;
    }
}
