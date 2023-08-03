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
@Table(name = "saving_taget")
public class saving_taget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger sv_id;
    private String name_sv;
    private String describe_sv;
    private Date start_date;
    private Date end_date;

    @OneToOne(mappedBy = "savingTaget")
    private user_model userModel;
}
