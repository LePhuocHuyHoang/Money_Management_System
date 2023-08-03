package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "categogy")
public class categogy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger categogy_id;
    private String name_categogy;
}