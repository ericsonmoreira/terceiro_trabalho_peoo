package br.uece.peoo.model;

public class Canal {

    private int numero;

    private String nome;

    private boolean hd;

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

    public boolean isHd() {
        return hd;
    }

    public void setHd(boolean hd) {
        this.hd = hd;
    }

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
