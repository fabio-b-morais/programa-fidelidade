package br.com.supermercado.fidelidade.aplicacao;

import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import br.com.supermercado.fidelidade.dominio.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CadastroUsuarioUseCase {
    private final UsuarioRepositorio repositorio;

    public CadastroUsuarioUseCase(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    public List<Usuario> buscarTodos() {
        return repositorio.buscarTodos();
    }

    public Usuario executar(String nome, String email) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        return repositorio.salvar(u);
    }
}
