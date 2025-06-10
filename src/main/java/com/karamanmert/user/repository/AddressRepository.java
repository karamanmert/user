package com.karamanmert.user.repository;

import com.karamanmert.user.entity.Address;
import com.karamanmert.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author karamanmert
 * @date 9.11.2024
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAddressesByUser(User user);

    @Modifying
    @Transactional
    @Query("DELETE FROM Address a WHERE a.addressId = :addressId")
    int deleteAddressById(@Param("addressId") String addressId);

    @Query("SELECT a FROM Address a WHERE a.addressId = :addressId")
    Optional<Address> findAddressesByAddressId(String addressId);
}
