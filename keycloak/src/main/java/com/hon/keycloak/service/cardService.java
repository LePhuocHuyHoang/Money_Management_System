package com.hon.keycloak.service;

import com.hon.keycloak.model.card;
import com.hon.keycloak.model.card_brand;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface cardService {
    List<card> getAllCard();
    card saveCard(card card);

    Object getCard(BigInteger cardId);

    void deleteCard(BigInteger cardId);

    card updateCard(BigInteger cardId, Map<String, String> formData);
}
