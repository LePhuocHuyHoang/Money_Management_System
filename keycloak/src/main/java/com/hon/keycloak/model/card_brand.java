package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
@Table(name = "card_brand")
public class card_brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger brand_id;
    private String name_brand;
}
