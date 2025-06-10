package com.karamanmert.user.entity;

import com.karamanmert.user.entity.base.BaseEntity;
import com.karamanmert.user.enums.GenderType;
import com.karamanmert.user.enums.UserRole;
import com.karamanmert.user.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
@Builder
public class User extends BaseEntity {

    @Column(name = "userId", nullable = false, unique = true)
    private String userId;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "surname", nullable = false)
    @Size(min = 2, max = 100)
    private String surname;

    @Column(name = "password", nullable = false)
    @Size(min = 2, max = 30)
    private String password;

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
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        if (this.userId == null) {
            this.userId = UUID.randomUUID().toString();
        }
    }
}