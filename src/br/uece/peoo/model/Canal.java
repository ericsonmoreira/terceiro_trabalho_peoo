package br.uece.peoo.model;

/**
 * Classe para repsentear um Canal de Televisão.
 */
public class Canal {

    private int numero; // número do canal

    private String nome; // nome do canal

    private boolean hd; // variável booleana para disser se o canal é ou não HD

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHd(boolean hd) {
        this.hd = hd;
    }

    public boolean isHd() {
        return hd;
    }

    /**
     * Contrutor padrão da classe.
     * @param numero número do
     * @param nome nome do canal
     * @param hd boobleando se o canal é HD
     */
    public Canal(int numero, String nome, boolean hd) {
        this.numero = numero;
        this.nome = nome;
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Canal{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", hd=" + hd +
                '}';
    }
}
