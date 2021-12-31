package com.ciceropinheiro.conductor.Spring.repository;

import com.ciceropinheiro.conductor.Spring.model.ERole;
import com.ciceropinheiro.conductor.Spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
