package br.com.supermercado.fidelidade.infraestrutura.persistencia.jpa;

import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUsuarioJpa extends JpaRepository<Usuario, Long> {}
