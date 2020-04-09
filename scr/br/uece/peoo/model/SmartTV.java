package br.uece.peoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A SmartTV sobrescreve o método de cadastrar canais inserindo todos os canais disponibilizados,
 * desde que não estejam já cadastrados.
 */
public class SmartTV extends Televisao {

    private int polegadas; // polegadas da Smart TV

    /**
     * Crie um construtor que receba como parâmetro a lista de canais disponíveis,
     * atribua-a à sua lista interna, e configure o volume para 5.
     *
     * @param id
     * @param canaisDisponiveis
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
     * A SmartTV implementa o método de cadastrar canais inserindo na lista de canais todos os
     * canais existentes na lista de canais disponíveis e, ao final, seta como canal atual o primeiro
     * da lista.
     * @param canais
     */
    public void cadastrarCanais() {
        cadastrarCanais(this.canaisDisponiveis);
    }

    @Override
    public void cadastrarCanais(List<Canal> canais) {
        for (Canal canal: canais) this.canaisCadastrados.add(canal);
        this.canalAtual = this.canaisCadastrados.get(0);
    }
}
