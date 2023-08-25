package com.hon.keycloak.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

//Tiến hành cấu hình bảo mật hệ thống và xác thực, ủy quyền
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                    .disable()   //Tắt cơ chế bảo vệ khỏi CSRF
                .authorizeHttpRequests()
                     .anyRequest()
                         .authenticated(); //Các yêu cầu phải được xác thực
        http
                .oauth2ResourceServer()
                     .jwt()
                        .jwtAuthenticationConverter(jwtAuthConverter); //Sử dụng JwtAuthConverter để chuyển đổi JWT thành đối tượng xác thực
        http
                .sessionManagement()
                    .sessionCreationPolicy(STATELESS); //Đặt chế độ tạo phiên (Không cần phiên)
        return http.build();
    }
}
