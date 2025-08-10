package com.portfolio.portfolio_api.repository;

import com.portfolio.portfolio_api.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
  int countByEmail(String email);
}
