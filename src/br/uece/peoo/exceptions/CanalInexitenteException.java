package br.uece.peoo.exceptions;

/**
 * Exceção chamada quando se tenta sintonizar um canal mas
 * ele não está entre a lista de canais disponíveis de uma TV.
 */
public class CanalInexitenteException extends Exception{

    private int numCanal; // número do canal.

    /**
     * Construtor padrão da classe.
     * @param message mensagem da exception.
     * @param numCanal número do canal que deu origem a exception.
     */
    public CanalInexitenteException(String message, int numCanal) {
        super(message);
        this.numCanal = numCanal;
    }

}
