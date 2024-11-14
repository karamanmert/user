package com.karamanmert.user.service.impl;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.repository.AddressRepository;
import com.karamanmert.user.service.spec.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.saveAndFlush(address);
    }
}
