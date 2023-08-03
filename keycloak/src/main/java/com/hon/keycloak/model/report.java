package com.hon.keycloak.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data
@Table(name = "report")
public class report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger report_id;
    private String name_report;
    private String type_report;
}
