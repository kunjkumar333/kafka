package com.example.spring.TokenService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.TokenService.Model.User;

@Repository
public interface TokenRepository extends JpaRepository<User, Long>{

}
