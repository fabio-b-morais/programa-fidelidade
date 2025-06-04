package br.com.supermercado.fidelidade.dominio.entidade;

import jakarta.persistence.*;

@Entity(name = "conta_pontos")
public class ContaPontos {
    @Id
    private Long usuarioId;
    private int saldo;

    protected ContaPontos() {
    }

    public ContaPontos(Long usuarioId, int saldo) {
        this.usuarioId = usuarioId;
        this.saldo = saldo;
    }

    public void adicionarPontos(int pontos) { this.saldo += pontos; }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
