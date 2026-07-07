package com.nhanshop.ecommerce.mapper;

import com.nhanshop.ecommerce.auth.dto.RegisterRequest;
import com.nhanshop.ecommerce.auth.dto.UserResponse;
import com.nhanshop.ecommerce.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toUser(RegisterRequest registerRequest);
    @Mapping(target = "roles", source = "roles")
    UserResponse toUserResponse(User user);

}
