package com.hon.keycloak.service;

import com.hon.keycloak.model.card_brand;

import java.math.BigInteger;
import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> 3934a3b3191a1c650f0bad8c8435ddf0524b2028

public interface card_brandService {
    List<card_brand> getAllCardBrand();
    card_brand saveCardBrand(card_brand cardBrand);

    Object getCardBrand(BigInteger cardBrandId);

    void deleteCardBrand(BigInteger cardBrandId);

<<<<<<< HEAD
    card_brand updateCardBrand(BigInteger cardBrandId, Map<String, String> formData);
=======
    card_brand updateCardBrand(BigInteger cardBrandId, card_brand updatedCardBrand);
>>>>>>> 3934a3b3191a1c650f0bad8c8435ddf0524b2028
}
