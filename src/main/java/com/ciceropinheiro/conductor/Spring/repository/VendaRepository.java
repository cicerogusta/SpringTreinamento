package com.ciceropinheiro.conductor.Spring.repository;

import com.ciceropinheiro.conductor.Spring.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
