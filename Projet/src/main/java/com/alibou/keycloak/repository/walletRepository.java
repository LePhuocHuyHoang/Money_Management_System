package com.alibou.keycloak.repository;

import com.alibou.keycloak.model.wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
@Repository
public interface walletRepository extends JpaRepository<wallet, BigInteger> {
}
