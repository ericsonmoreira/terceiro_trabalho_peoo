package br.uece.peoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que respresenta uma Smart TV
 */
public class SmartTV extends Televisao {

    private int polegadas; // polegadas da Smart TV

    /**
     * Construtor padrão da classe.
     * @param id identificador da classe. Exemplo: LG123
     * @param canaisDisponiveis lista de canis.
     */
    public SmartTV(String id, ArrayList<Canal> canaisDisponiveis) {
        super(id, canaisDisponiveis);
    }

    public int getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(int polegadas) {
        this.polegadas = polegadas;
    }

    /**
     * Insere na lista de canais cadastrados todos os canais existentes na lista
     * de canais disponíveis e, ao final, seta como canal atual o primeiro canal
     * da lista.
     */
    public void cadastrarCanais() {
        cadastrarCanais(this.canaisDisponiveis);
    }

    @Override
    public void cadastrarCanais(List<Canal> canais) {
        for (Canal canal: canais) this.canaisCadastrados.add(canal);
        this.canalAtual = this.canaisCadastrados.get(0);
    }

    @Override
    public String toString() {
        return "SmartTV{" +
                "polegadas=" + polegadas +
                ", id='" + id + '\'' +
                ", volume=" + volume +
                ", canalAtual=" + canalAtual +
                '}';
    }
}
