package com.hon.keycloak.controller;

import com.hon.keycloak.model.card;
import com.hon.keycloak.model.card_brand;
import com.hon.keycloak.service.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class cardController {
    @Autowired
    private final cardService cardService;

    public cardController(com.hon.keycloak.service.cardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<card>> findAllCard() {
        return ResponseEntity.ok(cardService.getAllCard());
    }
    @GetMapping("/{cardBrandId}")
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
    @DeleteMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card>> deleteCard(@PathVariable BigInteger cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok(cardService.getAllCard());
    }
    @PutMapping("/{cardBrandId}")
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
