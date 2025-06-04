
package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import br.com.supermercado.fidelidade.dominio.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CadastroUsuarioUseCaseTest {

    @Test
    void deveCadastrarUsuarioComSucesso() {
        UsuarioRepositorio repositorio = mock(UsuarioRepositorio.class);
        CadastroUsuarioUseCase useCase = new CadastroUsuarioUseCase(repositorio);

        String nome = "Fabio";
        String email = "fabio.b.morais@gmail.com";
        Usuario usuarioSimulado = new Usuario(nome, email);

        when(repositorio.salvar(any(Usuario.class))).thenReturn(usuarioSimulado);

        Usuario usuarioCriado = useCase.executar(nome, email);

        assertNotNull(usuarioCriado);
        assertEquals(nome, usuarioCriado.getNome());
    }
}
