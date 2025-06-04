package br.com.supermercado.fidelidade.dominio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PontoNaoEncontradoException extends RuntimeException {
    public PontoNaoEncontradoException(String id) {
        super("Ponto para o usuário com ID " + id + " não encontrado.");
    }
}
