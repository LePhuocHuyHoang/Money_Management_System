package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
@Table(name = "card")
public class card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger card_id;
    private int amount;
    private String card_number;
    private String symbol;
}
