package com.nhanshop.ecommerce.auth.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;
    private boolean authenticated;
}
