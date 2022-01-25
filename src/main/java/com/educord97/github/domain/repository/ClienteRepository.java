package com.educord97.github.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educord97.github.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

  List<Cliente> findByNome(String nome);

  // LIKE NO SQL 'CONTAINING'
  List<Cliente> findByNomeContaining(String nome);
}