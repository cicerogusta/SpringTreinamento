package com.ciceropinheiro.conductor.Spring.repository;

import com.ciceropinheiro.conductor.Spring.model.RefreshToken;
import com.ciceropinheiro.conductor.Spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByToken(String token);

  @Modifying
  int deleteByUser(User user);
}
