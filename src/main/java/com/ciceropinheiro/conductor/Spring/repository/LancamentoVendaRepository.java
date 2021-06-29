package com.ciceropinheiro.conductor.Spring.repository;

import com.ciceropinheiro.conductor.Spring.model.LancamentoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoVendaRepository extends JpaRepository<LancamentoVenda, Long> {
}
