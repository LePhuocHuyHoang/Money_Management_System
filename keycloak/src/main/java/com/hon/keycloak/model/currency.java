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
@Table(name = "currency")
public class currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger currency_id;
    private String name_currency;
}
