package br.com.supermercado.fidelidade.infraestrutura.persistencia.jpa;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringContaJpa extends JpaRepository<ContaPontos, Long> {}
