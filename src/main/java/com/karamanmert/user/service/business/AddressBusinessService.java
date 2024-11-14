package com.karamanmert.user.service.business;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.spec.AddressService;
import com.karamanmert.user.service.spec.CustomAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Service
@RequiredArgsConstructor
public class AddressBusinessService {

    private final AddressService addressService;
    private final UserBusinessService userBusinessService;
    private final CustomAddressMapper addressMapper;

    // todo: createdDate and lastUpdatedDate won't work.
    public AddressDto createAddress(String email, CreateAddressRequest request) {
        User user = userBusinessService.getByEmail(email);
        Address address = addressMapper.mapCreateRequestToEntity(request);
        address.setUser(user);
        if (user.getAddresses().isEmpty()) {
            user.setAddresses(new ArrayList<>());
        }
        user.getAddresses().add(address);
        userBusinessService.updateUser(user);
        Address savedAddress = addressService.save(address);
        return addressMapper.mapEntityToDto(savedAddress);
    }
}
