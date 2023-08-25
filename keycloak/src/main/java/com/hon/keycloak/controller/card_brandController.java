package com.hon.keycloak.controller;


import com.hon.keycloak.log.logger;
import com.hon.keycloak.entity.card_brand;
import com.hon.keycloak.service.card_brandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/card_brand")
public class card_brandController {
    @Autowired
    private  card_brandService cardBrandService;

    public card_brandController(card_brandService cardBrandService) {
        this.cardBrandService = cardBrandService;
    }
    //Find All Card Brand
    @GetMapping
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<List<card_brand>> findAllCardBrand() {
        logger.info("Find All Card Brand Success");
        return ResponseEntity.ok(cardBrandService.getAllCardBrand());
    }
    //Find Card Brand By ID
    @GetMapping("hasAnyRole('client_user', 'client_admin')")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card_brand> getCardBrand(@PathVariable BigInteger cardBrandId) {
        logger.info("Find Card Brand Success");
        return ResponseEntity.ok((card_brand) cardBrandService.getCardBrand(cardBrandId));
    }
    //Create New Card Brand
    @PostMapping
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<card_brand> saveCardBrand(card_brand cardBrand) {
        card_brand savedCardBrand = cardBrandService.saveCardBrand(cardBrand);
        logger.info("Create Card Brand Success");
        return ResponseEntity.ok(savedCardBrand);
    }
    //Delete Card Brand
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public List<card_brand> getCardBrandNotDeleted() {
        logger.info("Delete Card Brand Success");
        return cardBrandService.getCardBrandNotDeleted();
    }
    //Update Card Brand By ID
    @PutMapping("/{cardBrandId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<card_brand> updateCardBrand(@PathVariable BigInteger cardBrandId, @RequestParam Map<String, String> formData) {
        card_brand updatedCardBrandResult = cardBrandService.updateCardBrand(cardBrandId, formData);
        if (updatedCardBrandResult != null) {
            logger.info("Update Card Brand Success");
            return ResponseEntity.ok(updatedCardBrandResult);
        } else {
            logger.error("Can Find Brand Card Update");
            return ResponseEntity.notFound().build();
        }
    }

}
