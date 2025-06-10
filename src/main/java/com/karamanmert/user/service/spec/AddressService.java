package com.karamanmert.user.service.spec;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.model.dto.AddressDto;

import java.util.List;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface AddressService {

    Address findByAddressId(String addressId);

    Address save(Address address);

    List<Address> getAddressByUserId(User user);

    void deleteAddressById(String addressId);
}
