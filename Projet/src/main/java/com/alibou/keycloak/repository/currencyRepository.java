package com.alibou.keycloak.repository;

import com.alibou.keycloak.model.currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
@Repository
public interface currencyRepository extends JpaRepository<currency, BigInteger> {
}
