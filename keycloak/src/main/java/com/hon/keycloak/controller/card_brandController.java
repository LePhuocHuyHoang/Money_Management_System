package com.hon.keycloak.controller;

import com.hon.keycloak.model.card_brand;
import com.hon.keycloak.service.card_brandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
@RequestMapping("/card_brand")
public class card_brandController {
    @Autowired
    private final card_brandService cardBrandService;

    public card_brandController(card_brandService cardBrandService) {
        this.cardBrandService = cardBrandService;
    }
    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<card_brand>> findAllCardBrand() {
        return ResponseEntity.ok(cardBrandService.getAllCardBrand());
    }
    @GetMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card_brand> getCardBrand(@PathVariable BigInteger cardBrandId) {
        return ResponseEntity.ok((card_brand) cardBrandService.getCardBrand(cardBrandId));
    }
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card_brand> saveCardBrand(card_brand cardBrand) {
        card_brand savedCardBrand = cardBrandService.saveCardBrand(cardBrand);
        return ResponseEntity.ok(savedCardBrand);
    }
    @DeleteMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card_brand>> deleteCardBrand(@PathVariable BigInteger cardBrandId) {
        cardBrandService.deleteCardBrand(cardBrandId);
        return ResponseEntity.ok(cardBrandService.getAllCardBrand());
    }
    @PutMapping("/{cardBrandId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    //lỗi định dạng
    public ResponseEntity<card_brand> updateCardBrand(@PathVariable BigInteger cardBrandId, @RequestBody card_brand updatedCardBrand) {
        card_brand updatedCardBrandResult = cardBrandService.updateCardBrand(cardBrandId, updatedCardBrand);
        if (updatedCardBrandResult != null) {
            return ResponseEntity.ok(updatedCardBrandResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
