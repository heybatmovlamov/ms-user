package com.msuser.dao.entity;

import com.msuser.model.enums.UserRole;
import com.msuser.model.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "users")
@Data
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@FieldNameConstants
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "role", nullable = false)
    private UserRole role;

    @NotNull
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;
}
