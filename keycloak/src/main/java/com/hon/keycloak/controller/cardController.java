package com.hon.keycloak.controller;

import com.hon.keycloak.model.card;
import com.hon.keycloak.model.card_brand;
import com.hon.keycloak.service.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.hon.keycloak.repository.cardRepository;
import com.hon.keycloak.repository.card_brandRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class cardController {
    @Autowired
    private final cardService cardService;
    @Autowired
    private cardRepository cardRepository;
    @Autowired
    private card_brandRepository card_brandRepository;

    public cardController(com.hon.keycloak.service.cardService cardService, com.hon.keycloak.repository.cardRepository cardRepository, com.hon.keycloak.repository.card_brandRepository card_brandRepository) {
        this.cardService = cardService;
        this.cardRepository = cardRepository;
        this.card_brandRepository = card_brandRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<card>> findAllCard() {
        return ResponseEntity.ok(cardService.getAllCard());
    }
    @GetMapping("/{cardId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card> getCard(@PathVariable BigInteger cardId) {
        return ResponseEntity.ok((card) cardService.getCard(cardId));
    }
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card> saveCardBrand(card card) {
        card savedCard = cardService.saveCard(card);
        return ResponseEntity.ok(savedCard);
    }
    @PutMapping("/{cardId}/card_brand/{cardBrandId}")
    card addCardBrandToStudent(
            @PathVariable BigInteger cardId,
            @PathVariable BigInteger cardBrandId
    ) {
        card card = cardRepository.findById(cardId).get(); // Lấy đối tượng card từ repository
        card_brand cardBrand = card_brandRepository.findById(cardBrandId).get(); // Lấy đối tượng card_brand từ repository
        card.setCardBrand(cardBrand); // Đặt cardBrand cho card
        return cardRepository.save(card);
    }
    @DeleteMapping("/{cardId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card>> deleteCard(@PathVariable BigInteger cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok(cardService.getAllCard());
    }
    @PutMapping("/{cardId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card> updateCard(@PathVariable BigInteger cardId, @RequestParam Map<String, String> formData) {
        card updatedCardResult = cardService.updateCard(cardId, formData);
        if (updatedCardResult != null) {
            return ResponseEntity.ok(updatedCardResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
