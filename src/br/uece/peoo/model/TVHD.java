package br.uece.peoo.model;

import br.uece.peoo.model.Televisao;

import java.util.ArrayList;
import java.util.List;

/**
 * A segunda classe cadastra novos canais apenas se eles forem HD.
 */
public class TVHD extends Televisao {

    /**
     * Enum para os modelos.
     */
    public enum MODELO{
        LED, PLASMA, HD;
    }

    /**
     * Crie um construtor que receba como parâmetro a lista de canais disponíveis,
     * atribua-a à sua lista interna, e configure o volume para 5.
     *
     * @param id
     * @param canaisDisponiveis
     */
    public TVHD(String id, ArrayList<Canal> canaisDisponiveis) {
        super(id, canaisDisponiveis);
    }

    private MODELO modelo;

    /**
     * cadastra novos canais apenas se eles forem HD e, ao final, seta como canal
     * atual o último da lista.
     * @param canais
     */
    @Override
    public void cadastrarCanais(List<Canal> canais) {
        for (Canal canal: canais) if (canal.isHd()) this.canaisCadastrados.add(canal);
        this.canalAtual = this.canaisCadastrados.get(canaisCadastrados.size() - 1);
    }

    @Override
    public String toString() {
        return "TVHD{" +
                "modelo=" + modelo +
                ", id='" + id + '\'' +
                ", volume=" + volume +
                ", canalAtual=" + canalAtual +
                '}';
    }
}
