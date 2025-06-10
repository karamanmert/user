package com.karamanmert.user.controller;

import com.karamanmert.user.model.dto.UpdateAddressRequest;
import com.karamanmert.user.model.dto.AddressDto;
import com.karamanmert.user.model.request.CreateAddressRequest;
import com.karamanmert.user.service.business.AddressBusinessService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> deleteAddress(@Valid @NotBlank @PathVariable String addressId) {
        this.addressBusinessService.deleteAddressById(addressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable String addressId,
                                                    @Valid @RequestBody UpdateAddressRequest request) {
        return ResponseEntity.ok(addressBusinessService.updateAddress(addressId, request));
    }
}