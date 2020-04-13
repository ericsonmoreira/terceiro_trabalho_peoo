package br.uece.peoo.exceptions;

import br.uece.peoo.model.Televisao;

/**
 * Exceção chamada quando se tenta sintonizar um canal mas
 * ele não está entre a lista de canais disponíveis de uma TV.
 */
public class CanalInexitenteException extends Exception{

    private int numCanal; // número do canal.

    private Televisao televisao;

    /**
     * Construtor padrão da classe.
     * @param message mensagem da exception.
     * @param numCanal número do canal que deu origem a exception.
     */
    public CanalInexitenteException(String message, int numCanal, Televisao televisao) {
        super(message);
        this.numCanal = numCanal;
        this.televisao = televisao;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "{Tv Id: " + this.televisao.getId() + ", numCanal: " + numCanal + "}";
    }

}
