package com.nhanshop.ecommerce.user.entity;

import com.nhanshop.ecommerce.common.Entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    Long id;

    @Email
    @Column(name = "email",nullable = false,unique = true)
    String email;

    @Column(name = "full_name",nullable = false)
    String fullName;

    @Column(name = "phone_number",nullable = false,unique = true)
    String phoneNumber;

    @Column(name = "password",nullable = false)
    String password;

    @Column(name ="status",nullable = false)
    String status;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name ="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles = new HashSet<>();
}
