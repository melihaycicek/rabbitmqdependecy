package com.example.controller;

import com.example.exception.NotFoundException;
import com.example.exception.UnauthorizedException;
import com.example.model.FirstClassUser;
import com.example.service.FirstClassUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/first-class-users")
public class FirstClassUserController {

    private final FirstClassUserService firstClassUserService;

    @Autowired
    public FirstClassUserController(FirstClassUserService firstClassUserService) {
        this.firstClassUserService = firstClassUserService;
    }

    @GetMapping
    public ResponseEntity<List<FirstClassUser>> getAllFirstClassUsers() {
        List<FirstClassUser> firstClassUsers = firstClassUserService.getAllFirstClassUsers();
        return new ResponseEntity<>(firstClassUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirstClassUser> getFirstClassUserById(@PathVariable Long id) {
        FirstClassUser firstClassUser = firstClassUserService.getFirstClassUserById(id);
        if (firstClassUser != null) {
            return new ResponseEntity<>(firstClassUser, HttpStatus.OK);
        } else {
            throw new NotFoundException("FirstClassUser not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<FirstClassUser> createFirstClassUser(@RequestBody FirstClassUser firstClassUser) {
        FirstClassUser createdFirstClassUser = firstClassUserService.createFirstClassUser(firstClassUser);
        return new ResponseEntity<>(createdFirstClassUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FirstClassUser> updateFirstClassUser(@PathVariable Long id, @RequestBody FirstClassUser firstClassUser) {
        FirstClassUser updatedFirstClassUser = firstClassUserService.updateFirstClassUser(id, firstClassUser);
        if (updatedFirstClassUser != null) {
            return new ResponseEntity<>(updatedFirstClassUser, HttpStatus.OK);
        } else {
            throw new NotFoundException("FirstClassUser not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFirstClassUser(@PathVariable Long id) {
        boolean deleted = firstClassUserService.deleteFirstClassUser(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new NotFoundException("FirstClassUser not found with id: " + id);
        }
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        // Simulating unauthorized access
        throw new UnauthorizedException("Unauthorized access to protected endpoint");
    }
}
