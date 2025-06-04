
package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import br.com.supermercado.fidelidade.dominio.exception.PontoNaoEncontradoException;
import br.com.supermercado.fidelidade.dominio.repositorio.ContaPontosRepositorio;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsultaSaldoUseCaseTest {

    @Test
    void deveRetornarSaldoComSucesso() {
        ContaPontosRepositorio repositorio = mock(ContaPontosRepositorio.class);
        ConsultaSaldoUseCase useCase = new ConsultaSaldoUseCase(repositorio);

        Long usuarioId = 1L;
        ContaPontos conta = new ContaPontos(usuarioId, 200);
        when(repositorio.buscarPorUsuarioId(usuarioId)).thenReturn(Optional.of(conta));

        Integer saldo = useCase.executar(usuarioId);

        assertEquals(200, saldo);
    }
}
