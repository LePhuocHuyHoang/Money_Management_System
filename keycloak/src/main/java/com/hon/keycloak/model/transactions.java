package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "transactions")
public class transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger transaction_id;
    private int amount;
    private String note;
}
