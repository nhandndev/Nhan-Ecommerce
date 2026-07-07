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
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Permissions")
public class Permission extends BaseEntity {
    @Id
    @Column(name ="name")
    String name;

    @Column(name = "description",nullable = false)
    String description;

    @ManyToMany(mappedBy = "permissions")
    Set<Role> roles = new HashSet<>();

}
