package br.com.supermercado.fidelidade.entrada.controller;

import br.com.supermercado.fidelidade.aplicacao.CadastroUsuarioUseCase;
import br.com.supermercado.fidelidade.dominio.entidade.Usuario;
import br.com.supermercado.fidelidade.dominio.exception.UsuarioNaoEncontradoException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    private final CadastroUsuarioUseCase useCase;

    public UsuarioController(CadastroUsuarioUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return useCase.buscarTodos();
    }

    @GetMapping("/usuarios/{id}")
    public EntityModel<Usuario> buscarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = useCase.buscarPorId(id);

        if (usuario.isEmpty())
            throw new UsuarioNaoEncontradoException(id.toString());

        EntityModel<Usuario> entityModel = EntityModel.of(usuario.get());

        WebMvcLinkBuilder link =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).listarUsuarios());
        entityModel.add(link.withRel("usuarios"));

        return entityModel;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDTO dto) {

        Usuario usuario = useCase.executar(dto.nome(), dto.email());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    public record UsuarioDTO(String nome, String email) {
    }
}
