package com.karamanmert.user.controller;

import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.business.AddressBusinessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author karamanmert
 * @date 9.11.2024
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressBusinessService addressBusinessService;

    @PostMapping("{email}")
    public ResponseEntity<AddressDto> createAddress(@PathVariable String email,
                                                    @Valid @RequestBody CreateAddressRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBusinessService.createAddress(email, request));
    }
}