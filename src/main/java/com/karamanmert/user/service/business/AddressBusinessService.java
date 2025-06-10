package com.karamanmert.user.service.business;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.mapper.AddressMapper;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.dto.UpdateAddressRequest;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.spec.AddressService;
import com.karamanmert.user.service.spec.CustomAddressMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Service
@RequiredArgsConstructor
public class AddressBusinessService {

    private final AddressService addressService;
    private final UserBusinessService userBusinessService;
    private final CustomAddressMapper customAddressMapper;
    // private final AddressMapper addressMapper;

    // todo: createdDate won't work.
    @Transactional
    public AddressDto createAddress(String email, CreateAddressRequest request) {
        User user = userBusinessService.getByEmail(email);

        if(user == null) {
            throw new RuntimeException("user cannot be null");
        }

        Address address = customAddressMapper.mapRequestToEntity(request);
        address.setUser(user);

        user.getAddresses().add(address);
        Address savedAddress = addressService.save(address);
        userBusinessService.updateUser(user);

        return customAddressMapper.mapEntityToDto(savedAddress);
    }

    public List<AddressDto> getAddressByUserId(User user) {
        List<Address> addresses = this.addressService.getAddressByUserId(user);
        return this.customAddressMapper.mapEntityListToDtoList(addresses);
    }

    public void deleteAddressById(String addressId) {
        addressService.deleteAddressById(addressId);
    }

    public AddressDto updateAddress(String addressId, UpdateAddressRequest request) {
        Address address = addressService.findByAddressId(addressId);
        Address updatedAddress = customAddressMapper.updateEntity(address, request);
        return customAddressMapper.mapEntityToDto(updatedAddress);
    }
}
