package com.example.cinema1.Responsitory;

import com.example.cinema1.Modal.Entity.TokenActiveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokenRepository extends JpaRepository<TokenActiveUser, Integer>, JpaSpecificationExecutor<TokenActiveUser> {

    TokenActiveUser findByToken(String token);
}
