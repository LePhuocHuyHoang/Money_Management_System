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
@Table(name = "wallet")
public class wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger wallet_id;
    private int cash;
    private int creadit;
    private int total;
    private BigInteger keycloak_id;
}
