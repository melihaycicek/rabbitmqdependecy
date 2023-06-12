package com.example.service;

import com.example.entity.FirstClassUser;

import java.util.List;

public interface FirstClassUserService {

    FirstClassUser getFirstClassUserById(Long id);

    List<FirstClassUser> getAllFirstClassUsers();

    FirstClassUser createFirstClassUser(FirstClassUser user);

    FirstClassUser updateFirstClassUser(Long id, FirstClassUser user);

    void deleteFirstClassUser(Long id);
}
