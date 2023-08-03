package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Entity
@NoArgsConstructor
@Data
@Table(name = "user_model")
public class user_model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger user_id;
    private String email;
    private String email_verified;
    private String enabled;
    private String first_name;
    private String last_name;
}
