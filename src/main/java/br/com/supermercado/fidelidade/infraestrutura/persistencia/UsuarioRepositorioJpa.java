package br.com.supermercado.fidelidade.infraestrutura.persistencia;

import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import br.com.supermercado.fidelidade.dominio.repositorio.UsuarioRepositorio;
import br.com.supermercado.fidelidade.infraestrutura.persistencia.jpa.SpringUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositorioJpa implements UsuarioRepositorio {
    private final SpringUsuarioJpa springRepo;

    public UsuarioRepositorioJpa(SpringUsuarioJpa springRepo) {
        this.springRepo = springRepo;
    }

    public Usuario salvar(Usuario u) { return springRepo.save(u); }
    public Optional<Usuario> buscarPorId(Long id) { return springRepo.findById(id); }
    public List<Usuario> buscarTodos() { return springRepo.findAll(); }
}
