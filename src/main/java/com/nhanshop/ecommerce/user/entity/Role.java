package com.nhanshop.ecommerce.user.entity;

import com.nhanshop.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.*;
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
@Table(name = "Roles")
public class Role extends BaseEntity {
    @Id
    @Column(name = "name",nullable = false)
    String name;

    @Column(name = "description",nullable = false)
    String description;

    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name ="role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions = new HashSet<>();
}
