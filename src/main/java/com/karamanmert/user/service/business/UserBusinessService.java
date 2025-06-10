package com.karamanmert.user.service.business;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.dto.GetUserInfoDto;
import com.karamanmert.user.model.dto.UserDto;
import com.karamanmert.user.model.request.CreateUserRequest;
import com.karamanmert.user.service.spec.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
@Service
@RequiredArgsConstructor
public class UserBusinessService {

    private final UserService userService;
    private final Validator<User> userValidator;
    private final CustomUserMapper customUserMapper;
    private final AddressService addressService;
    private final CustomAddressMapper customAddressMapper;

    public UserDto createUser(CreateUserRequest request) {
        User user = customUserMapper.mapRequestToEntity(request);
        userValidator.isValidForCreate(user);
        userService.save(user);
        return customUserMapper.mapEntityToDto(user);
    }

    public void updateUser(User user) {
        userValidator.isValidForUpdate(user);
        userService.save(user);
    }

    public User getByEmail(String email) {
        return userService.findByEmail(email);
    }

    public GetUserInfoDto getUserInfo(String email) {
        final User user = userService.findByEmail(email);
        final UserDto userDto = customUserMapper.mapEntityToDto(user);
        final List<Address> addressList = addressService.getAddressByUserId(user);
        final List<AddressDto> addressDtos = customAddressMapper.mapEntityListToDtoList(addressList);

        return GetUserInfoDto.builder()
                .user(userDto)
                .addresses(addressDtos)
                .build();
    }
}
