package com.hon.keycloak.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card")
public class card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger card_id;
    private int amount;
    private String card_number;
    private String symbol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private card_brand cardBrand;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<transactions> transactions;

}
