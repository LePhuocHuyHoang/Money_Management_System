package com.alibou.keycloak.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "card_brand")
public class card_brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger brand_id;
    private String name_brand;

    @OneToOne(mappedBy = "cardBrand")
    private card card;


}