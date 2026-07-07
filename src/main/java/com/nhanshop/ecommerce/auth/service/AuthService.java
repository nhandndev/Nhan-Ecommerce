package com.nhanshop.ecommerce.auth.service;

import com.nhanshop.ecommerce.auth.dto.AuthResponse;
import com.nhanshop.ecommerce.auth.dto.RegisterRequest;
import com.nhanshop.ecommerce.auth.dto.UserResponse;
import com.nhanshop.ecommerce.common.exception.AppException;
import com.nhanshop.ecommerce.common.exception.ErrorCode;
import com.nhanshop.ecommerce.common.response.ApiResponse;
import com.nhanshop.ecommerce.enums.UserStatus;
import com.nhanshop.ecommerce.mapper.UserMapper;
import com.nhanshop.ecommerce.user.entity.Role;
import com.nhanshop.ecommerce.user.entity.User;
import com.nhanshop.ecommerce.user.repository.RoleRepository;
import com.nhanshop.ecommerce.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Transactional
    public UserResponse register(RegisterRequest registerRequest){
        User user = userMapper.toUser(registerRequest);

        if(userRepository.existsByemail(user.getEmail())){
            throw new AppException((ErrorCode.EMAIL_EXISTED));
        }
        if(userRepository.existsByphoneNumber(user.getPhoneNumber())){
            throw new AppException((ErrorCode.PHONE_NUMBER_EXISTED));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       Role role = roleRepository.findByName("BUYER").orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND));
        Set<Role> roles = new HashSet<>();

        roles.add(role);
        user.setRoles(roles);
        user.setStatus(UserStatus.ACTIVE);
        user = userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
