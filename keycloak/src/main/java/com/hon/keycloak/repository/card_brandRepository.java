package com.hon.keycloak.repository;

import com.hon.keycloak.model.card_brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface card_brandRepository extends JpaRepository<card_brand, BigInteger> {
}
