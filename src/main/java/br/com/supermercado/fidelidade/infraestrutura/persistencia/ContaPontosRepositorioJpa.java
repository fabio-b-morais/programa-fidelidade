package br.com.supermercado.fidelidade.infraestrutura.persistencia;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import br.com.supermercado.fidelidade.dominio.exception.UsuarioNaoEncontradoException;
import br.com.supermercado.fidelidade.dominio.repositorio.ContaPontosRepositorio;
import br.com.supermercado.fidelidade.infraestrutura.persistencia.jpa.SpringContaJpa;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ContaPontosRepositorioJpa implements ContaPontosRepositorio {
    private final SpringContaJpa springRepo;

    public ContaPontosRepositorioJpa(SpringContaJpa springRepo) {
        this.springRepo = springRepo;
    }

    public ContaPontos salvar(ContaPontos c) { return springRepo.save(c); }
    public Optional<ContaPontos> buscarPorUsuarioId(Long id) {
        return Optional.ofNullable(springRepo.findById(id).orElseThrow(()
                -> new UsuarioNaoEncontradoException(id.toString())));
    }
}
