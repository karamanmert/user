package com.karamanmert.user.entity;

import com.karamanmert.user.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * @author karamanmert
 * @date 8.11.2024
 */

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {

    @Column(name = "address_id", nullable = false, unique = true)
    private String addressId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "custom_address", nullable = false)
    @Size(max = 500)
    private String customAddress;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        if (this.addressId == null) {
            this.addressId = String.valueOf(UUID.randomUUID());
        }
    }
}