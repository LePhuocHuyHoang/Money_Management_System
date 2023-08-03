package com.hon.keycloak.service;

import com.hon.keycloak.model.card_brand;

import java.math.BigInteger;
import java.util.List;

public interface card_brandService {
    List<card_brand> getAllCardBrand();
    card_brand saveCardBrand(card_brand cardBrand);

    Object getCardBrand(BigInteger cardBrandId);

    void deleteCardBrand(BigInteger cardBrandId);

    card_brand updateCardBrand(BigInteger cardBrandId, card_brand updatedCardBrand);
}
