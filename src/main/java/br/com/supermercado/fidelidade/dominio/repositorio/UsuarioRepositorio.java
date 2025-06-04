package br.com.supermercado.fidelidade.dominio.repositorio;

import br.com.supermercado.fidelidade.dominio.entidade.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
    public List<Usuario> buscarTodos();
}