package br.uece.peoo.model;

import br.uece.peoo.exceptions.CanalInexitenteException;
import br.uece.peoo.exceptions.TvJaCadastradaException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Controle Remoto
 */
public class ControleRemoto {

    private List<Televisao> TVs; // lista de televisores

    /**
     * Construtor padrao da classe.
     */
    public ControleRemoto() {
        this.TVs = new ArrayList<Televisao>();
    }

    public List<Televisao> getTVs() {
        return TVs;
    }

    public void setTVs(List<Televisao> TVs) {
        this.TVs = TVs;
    }

    /**
     * Adicionando uma {@link Televisao}
     *
     * @param televisao
     */
    public void addTv(Televisao televisao) throws TvJaCadastradaException {
        if (this.TVs.contains(televisao)) {
            throw new TvJaCadastradaException("Televisao já cadastrada", televisao);
        } else {
            this.TVs.add(televisao);
        }
    }

    /**
     * Aumenta o volume de todas tvs
     */
    public void aumentarVolume() {
        this.TVs.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.UP));
    }

    /**
     * Diminui o volume de todas tvs
     */
    public void diminuirVolume() {
        this.TVs.forEach(televisao -> televisao.alterarVolume(Televisao.COMANDO_TV.DOWN));
    }

    /**
     * Muda o canal atual para um canal alvo.
     * @param canal canal alvo.
     */
    public void sintonizarCanal(Canal canal) {
        this.TVs.forEach(televisao -> {
            try {
                televisao.sintonizar(canal.getNumero());
            } catch (CanalInexitenteException e) {
                System.err.println(e.getMessage());
            }
        });
    }

    /**
     * Muda o canal atual de todas tvs para o próximo canal.
     */
    public void proximoCanal() {
        this.TVs.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.UP));
    }

    /**
     * Muda o canal aual de todas tvs para o canal anterior.
     */
    public void anteriorCanal() {
        this.TVs.forEach(televisao -> televisao.alterarCanal(Televisao.COMANDO_TV.DOWN));
    }

    /**
     * Informa o nome, número e se é HD o canal atual de cada tv de suas Tvs.
     */
    public void informarDados() {
        this.TVs.forEach(televisao -> {
            System.out.println("Tv Id: " + televisao.getId());
            televisao.informarDados(); // mostra apenas o canal atual.
        });
    }

    /**
     * Mostra a grade de canais de cada TV cadastrada.
     */
    public void mostrarGrade() {
        this.TVs.forEach(televisao -> televisao.mostarGrade());
    }

    @Override
    public String toString() {
        return "ControleRemoto{" +
                "televisores=" + TVs +
                '}';
    }

}
