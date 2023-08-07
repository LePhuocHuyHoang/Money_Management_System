package com.hon.keycloak.service.Impl;
import com.hon.keycloak.service.card_brandService;
import com.hon.keycloak.model.card_brand;
import com.hon.keycloak.repository.card_brandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
<<<<<<< HEAD
import java.util.Map;

=======
>>>>>>> 3934a3b3191a1c650f0bad8c8435ddf0524b2028
@Service
public class card_brandServiceImp implements card_brandService{
    private final card_brandRepository cardBrandRepository;
    @Autowired
    public card_brandServiceImp(card_brandRepository cardBrandRepository) {
        this.cardBrandRepository = cardBrandRepository;
    }

    public List<card_brand> getAllCardBrand(){
        return cardBrandRepository
                .findAll();
    }

    @Override
    public card_brand saveCardBrand(card_brand cardBrand) {
        cardBrandRepository.save(cardBrand);
        return cardBrand;
    }

    @Override
    public Object getCardBrand(BigInteger cardBrandId) {
        return cardBrandRepository
                .findById(cardBrandId)
                .orElse(null);
    }

    @Override
    public void deleteCardBrand(BigInteger cardBrandId) {
        cardBrandRepository.deleteById(cardBrandId);
    }
<<<<<<< HEAD
    @Override
    public card_brand updateCardBrand(BigInteger cardBrandId, Map<String, String> formData) {
        card_brand existingCardBrand = cardBrandRepository.findById(cardBrandId).orElse(null);
        if (existingCardBrand != null) {
            String nameBrand = formData.get("name_brand");
            existingCardBrand.setName_brand(nameBrand);
=======

    @Override
    public card_brand updateCardBrand(BigInteger cardBrandId, card_brand updatedCardBrand) {
        card_brand existingCardBrand = cardBrandRepository.findById(cardBrandId).orElse(null);
        if (existingCardBrand != null) {
            existingCardBrand.setName_brand(updatedCardBrand.getName_brand());
>>>>>>> 3934a3b3191a1c650f0bad8c8435ddf0524b2028
            return cardBrandRepository.save(existingCardBrand);
        }
        return null;
    }
}
