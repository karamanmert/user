package com.karamanmert.user.service.impl;

import com.karamanmert.common_lib.enums.ErrorCode;
import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.exception.ApiException;
import com.karamanmert.user.repository.AddressRepository;
import com.karamanmert.user.service.spec.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address findByAddressId(String addressId) {
        return addressRepository.findAddressesByAddressId(addressId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ErrorCode.ADDRESS_NOT_FOUND));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public List<Address> getAddressByUserId(User user) {
        return addressRepository.findAddressesByUser(user);
    }

    @Override
    public void deleteAddressById(String addressId) {
        int deleted = addressRepository.deleteAddressById(addressId);
        if (deleted < 1) {
            throw new ApiException(HttpStatus.NOT_FOUND, ErrorCode.ADDRESS_NOT_FOUND);
        }
    }
}
