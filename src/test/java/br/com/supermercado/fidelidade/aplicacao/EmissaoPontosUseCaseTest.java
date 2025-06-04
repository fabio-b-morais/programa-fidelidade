
package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.ContaPontos;
import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import br.com.supermercado.fidelidade.dominio.exception.UsuarioNaoEncontradoException;
import br.com.supermercado.fidelidade.dominio.repositorio.ContaPontosRepositorio;
import br.com.supermercado.fidelidade.dominio.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmissaoPontosUseCaseTest {

    @Test
    void deveEmitirPontosParaUsuarioExistente() {
        UsuarioRepositorio usuarioRepo = mock(UsuarioRepositorio.class);
        ContaPontosRepositorio contaRepo = mock(ContaPontosRepositorio.class);
        EmissaoPontosUseCase useCase = new EmissaoPontosUseCase(usuarioRepo, contaRepo);

        Long usuarioId = 1L;
        Usuario usuario = new Usuario("Fabio", "fabio.b.morais@.com");
        ContaPontos conta = new ContaPontos(usuarioId, 100);

        when(usuarioRepo.buscarPorId(usuarioId)).thenReturn(Optional.of(usuario));
        when(contaRepo.buscarPorUsuarioId(usuarioId)).thenReturn(Optional.of(conta));

        useCase.executar(usuarioId, 50);

        verify(contaRepo).salvar(conta);
        assertEquals(150, conta.getSaldo());
    }
}
