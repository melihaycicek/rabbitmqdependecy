package com.example.controller;

import com.example.exception.NotFoundException;
import com.example.exception.UnauthorizedException;
import com.example.model.BusinessAccount;
import com.example.service.BusinessAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business-accounts")
public class BusinessAccountController {

    private final BusinessAccountService businessAccountService;

    @Autowired
    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }

    @GetMapping
    public ResponseEntity<List<BusinessAccount>> getAllBusinessAccounts() {
        List<BusinessAccount> businessAccounts = businessAccountService.getAllBusinessAccounts();
        return new ResponseEntity<>(businessAccounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessAccount> getBusinessAccountById(@PathVariable Long id) {
        BusinessAccount businessAccount = businessAccountService.getBusinessAccountById(id);
        if (businessAccount != null) {
            return new ResponseEntity<>(businessAccount, HttpStatus.OK);
        } else {
            throw new NotFoundException("BusinessAccount not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<BusinessAccount> createBusinessAccount(@RequestBody BusinessAccount businessAccount) {
        BusinessAccount createdBusinessAccount = businessAccountService.createBusinessAccount(businessAccount);
        return new ResponseEntity<>(createdBusinessAccount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessAccount> updateBusinessAccount(@PathVariable Long id, @RequestBody BusinessAccount businessAccount) {
        BusinessAccount updatedBusinessAccount = businessAccountService.updateBusinessAccount(id, businessAccount);
        if (updatedBusinessAccount != null) {
            return new ResponseEntity<>(updatedBusinessAccount, HttpStatus.OK);
        } else {
            throw new NotFoundException("BusinessAccount not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessAccount(@PathVariable Long id) {
        boolean deleted = businessAccountService.deleteBusinessAccount(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new NotFoundException("BusinessAccount not found with id: " + id);
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        // Simulating unauthorized access
        throw new UnauthorizedException("Unauthorized access to protected endpoint");
    }
}
