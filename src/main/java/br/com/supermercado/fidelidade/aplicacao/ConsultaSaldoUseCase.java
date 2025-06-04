package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import br.com.supermercado.fidelidade.dominio.repositorio.ContaPontosRepositorio;
import org.springframework.stereotype.Component;

@Component
public class ConsultaSaldoUseCase {
    private final ContaPontosRepositorio repositorio;

    public ConsultaSaldoUseCase(ContaPontosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public int executar(Long usuarioId) {
        return repositorio.buscarPorUsuarioId(usuarioId)
                .map(ContaPontos::getSaldo)
                .orElse(0);
    }
}
