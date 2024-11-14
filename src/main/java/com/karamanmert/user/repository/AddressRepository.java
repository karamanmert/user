package com.karamanmert.user.repository;

import com.karamanmert.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
