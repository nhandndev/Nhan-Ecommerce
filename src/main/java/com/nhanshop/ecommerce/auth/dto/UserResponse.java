package com.nhanshop.ecommerce.auth.dto;

import com.nhanshop.ecommerce.enums.UserStatus;
import com.nhanshop.ecommerce.user.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String email;
    String fullName;
    String phoneNumber;
    UserStatus status;
    Set<RoleResponse> roles;
}
