package br.uece.peoo.model;

import java.util.ArrayList;

/**
 * Crie uma classe Televisão que contém como atributos um id (pode ser o nome do
 * fabricante e um número de modelo qualquer, ex: LG345), o volume, o canal atual, uma
 * lista de canais cadastrados, e uma lista de canais disponíveis. Crie uma constante com o
 * volume máximo = 10 e outra com o volume mínimo = 0. Crie um construtor que receba
 * como parâmetro a lista de canais disponíveis, atribua-a à sua lista interna, e configure o
 * volume para 5. Crie métodos de get e set para o volume e para canal atual.
 */
public class Televisao {

    public final static int VOL_MAX = 10;   // volume máximo
    public final static int VOL_MIN = 0;    // volume mínimo

    private String id; // decidimos padronizar o id como LG.345, separando o fabricante e o modelo por um ponto

    private int volume;

    private Canal canalAtual;

    private ArrayList<Canal> canaisCadastrados;

    private ArrayList<Canal> canaisDisponiveis;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }

    /**
     * Crie um construtor que receba como parâmetro a lista de canais disponíveis,
     * atribua-a à sua lista interna, e configure o volume para 5.
     * @param id
     * @param canaisDisponiveis
     */
    public Televisao(String id, ArrayList<Canal> canaisDisponiveis) {
        this.id = id;
        this.volume = 5; // configuração padão.
        this.canaisDisponiveis = canaisDisponiveis;
    }
}
