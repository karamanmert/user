package com.karamanmert.user.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

/**
 * @author karamanmert
 * @date 8.11.2024
 */

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", columnDefinition = "DATE")
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "last_modified_date", columnDefinition = "DATE")
    @UpdateTimestamp
    private LocalDate lastModifiedDate;
}
