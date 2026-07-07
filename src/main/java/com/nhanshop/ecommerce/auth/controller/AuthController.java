package com.nhanshop.ecommerce.auth.controller;

import com.nhanshop.ecommerce.auth.dto.AuthResponse;
import com.nhanshop.ecommerce.auth.dto.RegisterRequest;
import com.nhanshop.ecommerce.auth.dto.UserResponse;
import com.nhanshop.ecommerce.auth.service.AuthService;
import com.nhanshop.ecommerce.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ApiResponse<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Register Successfully")
                .data(authService.register(registerRequest))
                .build();
    }
}
