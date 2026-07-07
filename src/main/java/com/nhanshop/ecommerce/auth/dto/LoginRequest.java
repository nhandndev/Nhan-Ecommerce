package com.nhanshop.ecommerce.auth.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    @Email(message = "Email không đúng định dạng")
    @NotBlank(message = "Email không được để trống")
    String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    String password;
}