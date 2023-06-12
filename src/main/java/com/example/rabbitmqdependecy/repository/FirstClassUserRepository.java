package com.example.repository;

import com.example.model.FirstClassUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstClassUserRepository extends JpaRepository<FirstClassUser, Long> {

}
