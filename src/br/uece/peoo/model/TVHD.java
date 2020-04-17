package br.uece.peoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representar uma Televisao HD
 */
public class TVHD extends Televisao {

    /**
     * Enum para os modelos.
     */
    public enum MODELO{
        LED, PLASMA, HD;
    }

    public MODELO getModelo() {
        return modelo;
    }

    public void setModelo(MODELO modelo) {
        this.modelo = modelo;
    }

    private MODELO modelo; // Modelo da TVHD

    public TVHD(String id, ArrayList<Canal> canaisDisponiveis, MODELO modelo) {
        super(id, canaisDisponiveis);
        this.modelo = modelo;
    }

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
