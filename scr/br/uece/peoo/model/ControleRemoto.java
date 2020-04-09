package br.uece.peoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Crie uma classe ControleRemoto que pode manipular uma lista de televisões, sejam elas
 * SmartTvs ou TVHDs (use polimorfismo, ou seja, considere todas do tipo Televisão), ao
 * mesmo tempo. Portanto, o controle tem como atributo a lista de TVs que ele controla.
 * Crie um método para adicionar TV, que recebe um objeto do tipo Televisão e o adiciona na
 * lista de TVs apenas se a TV não estiver cadastrada. Se já estiver, dispare uma exceção de
 * TV já cadastrada.
 */
public class ControleRemoto {

    private List<Televisao> TVs;

    /**
     * Construtor padrao.
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
    public void addTv(Televisao televisao) throws Exception {
        if (this.TVs.contains(televisao)) {
            throw new Exception("Televisao já cadastrada: " + televisao);
        } else {
            this.TVs.add(televisao);
        }
    }

    @Override
    public String toString() {
        return "ControleRemoto{" +
                "televisores=" + TVs +
                '}';
    }

}
