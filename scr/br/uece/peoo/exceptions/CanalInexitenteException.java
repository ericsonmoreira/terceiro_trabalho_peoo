package br.uece.peoo.exceptions;

public class CanalInexitenteException extends Exception{

    private int numCanal;

    public CanalInexitenteException(String message, int numCanal) {
        super(message);
        this.numCanal = numCanal;
    }
}
