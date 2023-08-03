package com.hon.keycloak.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "income")
public class income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger income_id;
    private Date date_time;
}
