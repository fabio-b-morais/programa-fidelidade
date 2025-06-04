package br.com.supermercado.fidelidade.entrada.controller;

import br.com.supermercado.fidelidade.aplicacao.ConsultaSaldoUseCase;
import br.com.supermercado.fidelidade.aplicacao.EmissaoPontosUseCase;
import br.com.supermercado.fidelidade.dominio.exception.PontoNaoEncontradoException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pontos")
public class PontosController {
    private final EmissaoPontosUseCase emissao;
    private final ConsultaSaldoUseCase consulta;

    public PontosController(EmissaoPontosUseCase emissao, ConsultaSaldoUseCase consulta) {
        this.emissao = emissao;
        this.consulta = consulta;
    }

    @PostMapping("/emitir")
    public void emitir(@RequestBody PontosDTO dto) {
        emissao.executar(dto.usuarioId(), dto.pontos());
    }

    @GetMapping("/{usuarioId}")
    public SaldoResponse saldo(@PathVariable Long usuarioId) {
        int pontos = consulta.executar(usuarioId);
        if (pontos==0)
            throw new PontoNaoEncontradoException("usuarioId: "+usuarioId);
        return new SaldoResponse(pontos);
    }

    public record PontosDTO(Long usuarioId, int pontos) {}
    public record SaldoResponse(Integer valor) {}
}