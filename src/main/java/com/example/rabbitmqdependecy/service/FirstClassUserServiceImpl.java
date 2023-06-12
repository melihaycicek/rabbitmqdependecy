package com.example.service;

import com.example.entity.FirstClassUser;
import com.example.repository.FirstClassUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstClassUserServiceImpl implements FirstClassUserService {

    private final FirstClassUserRepository userRepository;

    @Autowired
    public FirstClassUserServiceImpl(FirstClassUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public FirstClassUser getFirstClassUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<FirstClassUser> getAllFirstClassUsers() {
        return userRepository.findAll();
    }

    @Override
    public FirstClassUser createFirstClassUser(FirstClassUser user) {
        return userRepository.save(user);
    }

    @Override
    public FirstClassUser updateFirstClassUser(Long id, FirstClassUser user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteFirstClassUser(Long id) {
        userRepository.deleteById(id);
    }
}
