package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import br.com.supermercado.fidelidade.dominio.repositorio.ContaPontosRepositorio;
import br.com.supermercado.fidelidade.dominio.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Component;

@Component
public class EmissaoPontosUseCase {
    private final ContaPontosRepositorio repositorio;

    public EmissaoPontosUseCase(UsuarioRepositorio usuarioRepo, ContaPontosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void executar(Long usuarioId, int pontos) {
        ContaPontos conta = repositorio.buscarPorUsuarioId(usuarioId)
                .orElse(new ContaPontos(usuarioId, 0));
        conta.adicionarPontos(pontos);
        repositorio.salvar(conta);
    }
}
