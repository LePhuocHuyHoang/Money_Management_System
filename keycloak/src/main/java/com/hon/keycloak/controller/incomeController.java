package com.hon.keycloak.controller;

import com.hon.keycloak.log.logger;
import com.hon.keycloak.entity.income;
import com.hon.keycloak.service.incomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/income")
public class incomeController {
    @Autowired
    private final incomeService incomeService;

    public incomeController(incomeService incomeService) {
        this.incomeService = incomeService;
    }
    //Find All Income
    @GetMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<income>> findAllIncome() {
        logger.info("Find All Income Success");
        return ResponseEntity.ok(incomeService.getAllIncome());
    }
    //Find Income By ID
    @GetMapping("/{incomeId}")
    @PreAuthorize("hasAnyRole('client_user', 'client_admin')")
    public ResponseEntity<income> getIncome(@PathVariable BigInteger incomeId) {
        logger.info("Find Income Success");
        return ResponseEntity.ok((income) incomeService.getIncome(incomeId));
    }
    //Create New Income
    @PostMapping
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<income> saveIncome(income income) {
        income savedIncome = incomeService.saveIncome(income);
        logger.info("Create Income Success");
        return ResponseEntity.ok(savedIncome);
    }
    //Delete Income
    @GetMapping("/not-deleted")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<List<income>> getIncomeNotDeleted() {
        List<income> notDeletedIncome = incomeService.getIncomeNotDeleted();
        logger.info("Delete Income Success");
        return ResponseEntity.ok(notDeletedIncome);
    }
    //Update Income By ID
    @PutMapping("/{incomeId}")
    @PreAuthorize("hasRole('client_admin')")
    public ResponseEntity<income> updateIncome(@PathVariable BigInteger incomeId, @RequestParam Map<String, String> formData) {
        income updatedIncomeResult =incomeService.updateIncome(incomeId, formData);
        if (updatedIncomeResult != null) {
            logger.info("Update Income Success");
            return ResponseEntity.ok(updatedIncomeResult);
        } else {
            logger.error("Can Find Income Update");
            return ResponseEntity.notFound().build();
        }
    }
}
