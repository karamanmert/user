package com.karamanmert.user.mapper;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author karamanmert
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
/*
    Address mapRequestToEntity(CreateAddressRequest request);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "neighborhood", target = "neighborhood")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "customAddress", target = "customAddress")
    @Mapping(source = "addressId", target = "addressId")
    AddressDto mapEntityToDto(Address address);

    List<AddressDto> mapEntityListToDtoList(List<Address> address);

 */
}
