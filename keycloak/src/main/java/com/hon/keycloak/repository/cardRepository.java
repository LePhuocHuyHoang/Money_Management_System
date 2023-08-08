package com.hon.keycloak.repository;

import com.hon.keycloak.model.card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface cardRepository extends JpaRepository<card, BigInteger> {
}
//