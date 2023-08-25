package com.hon.keycloak.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "income")
public class income {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger income_id;
    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
    private Date date_time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id")
    @JsonManagedReference
    private transactions transactions;

}
//