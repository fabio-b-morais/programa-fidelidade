package br.com.supermercado.fidelidade.dominio.repositorio;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;

import java.util.Optional;

public interface ContaPontosRepositorio {
    ContaPontos salvar(ContaPontos conta);
    Optional<ContaPontos> buscarPorUsuarioId(Long id);
}
