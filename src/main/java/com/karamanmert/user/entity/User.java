package com.karamanmert.user.entity;

import com.karamanmert.user.entity.base.BaseEntity;
import com.karamanmert.user.enums.GenderType;
import com.karamanmert.user.enums.UserRole;
import com.karamanmert.user.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

/**
 * @author karamanmert
 * @date 8.11.2024
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "surname", nullable = false)
    @Size(min = 2, max = 100)
    private String surname;

    @Column(name = "password", nullable = false)
    @Size(min = 2, max = 30)
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @Size(min = 2, max = 50)
    private String username;

    @Column(name = "phone_number", nullable = false, unique = true)
    @Size(max = 10)
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    @Size(max = 150)
    private String email;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // mappedBy kısmı addresste nasıl tanımladığımızdır.
    private List<Address> addresses;
}