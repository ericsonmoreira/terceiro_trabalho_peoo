package br.uece.peoo.exceptions;

import br.uece.peoo.model.Televisao;

/**
 * Exception que acontece quando uma instância de {@link Televisao} já está cadastrada
 * na lista de Tvs de um obj da classe {@link br.uece.peoo.model.ControleRemoto}.
 */
public class TvJaCadastradaException extends Exception{

    private Televisao televisao; // Tv que já está cadastrada.

    public TvJaCadastradaException(String msg, Televisao televisao) {
        super(msg); // passa a msg pelo construtor da classe mãe.
        this.televisao = televisao;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "{Tv Id: " + televisao.getId() + "}";
    }
}
