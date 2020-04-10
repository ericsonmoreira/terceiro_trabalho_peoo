package br.uece.peoo.model;

import br.uece.peoo.exceptions.CanalInexitenteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Crie uma classe Televisão que contém como atributos um id (pode ser o nome do
 * fabricante e um número de modelo qualquer, ex: LG345), o volume, o canal atual, uma
 * lista de canais cadastrados, e uma lista de canais disponíveis. Crie uma constante com o
 * volume máximo = 10 e outra com o volume mínimo = 0. Crie um construtor que receba
 * como parâmetro a lista de canais disponíveis, atribua-a à sua lista interna, e configure o
 * volume para 5. Crie métodos de get e set para o volume e para canal atual.
 */
public abstract class Televisao {

    // Enum que representa os comandos de aumentar e diminuir volume.
    public enum COMANDO_TV {
        UP(1), DOWN(-1);
        private int valor;
        COMANDO_TV(int valor) {
            this.valor = valor;
        }
    }

    // Constantes
    public final static int VOL_MAX = 10;   // volume máximo
    public final static int VOL_MIN = 0;    // volume mínimo

    protected String id; // decidimos padronizar o id como LG.345, separando o fabricante e o modelo por um ponto

    protected int volume;

    protected Canal canalAtual;

    protected ArrayList<Canal> canaisCadastrados;

    protected ArrayList<Canal> canaisDisponiveis;

    public int getVolume() {
        return volume;
    }

    /**
     * Volumeno naum pode ser maior que VOL_MAX nem menor que VOL_MIN.
     * Caso o naum obedeca essa condicao, o valor permanece o mesmo.
     *
     * @param voloume volume da TV entre VOL_MAX e VOL_MIN.
     */
    public void setVolume(int voloume) {
        this.volume = (voloume > VOL_MAX || voloume < VOL_MIN ? this.volume: voloume);
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
        this.canaisCadastrados = new ArrayList<Canal>();
    }

    /**
     * recebe como parâmetro se aumenta ou diminui. No primeiro caso, incrementa o volume da TV em 1 unidade,
     * mas não pode ultrapassar o máximo. No segundo caso, decrementa o volume da TV em 1 unidade, mas não pode
     * ultrapassar o mínimo.
     *
     * @param COMANDOVOLTV {@link COMANDO_TV} UP_VOL ou DOWN_VOL.
     */
    public void alterarVolume(COMANDO_TV COMANDOVOLTV){
        setVolume(getVolume() + COMANDOVOLTV.valor);
    }

    public abstract void cadastrarCanais(List<Canal> canais);

    /**
     * Recebe como parâmetro um número, representando o canal da TV desejado, busca na lista de canais o
     * canal com esse número e, caso exista, altera o canal atual para este. Caso não exista, apresenta
     * mensagem de canal inexistente.
     *
     * @param num numero do canal desejado.
     */
    public void sintonizar(int num) throws CanalInexitenteException {
        // tenta encontrar o canal nos canais cadastrados.
        Canal canalPossivel = this.canaisCadastrados.stream().
                filter(canal -> canal.getNumero() == num).findFirst().get();
        if (canalPossivel != null) {
            this.canalAtual = canalPossivel;
        } else { // se não encontrar, dispara essa exception
            throw new CanalInexitenteException("Canal não exite", num);
        }
    }

    /**
     * Recebe como parâmetro se seleciona o próximo canal ou o anterior e altera o canal atual de acordo com o
     * solicitado. Se o canal atual for o último da lista e for solicitado próximo canal, deve-se alterar o canal
     * para o primeiro da lista. Já se for o primeiro canal e solicitar o anterior, deve-se setar o canal atual
     * como o último da lista.
     */
    public void alterarCanal(COMANDO_TV comando){
        int index = canaisCadastrados.indexOf(this.canalAtual); // pega a posicao do canal atual no list de canais.
        index = (index + comando.valor) % canaisCadastrados.size();
        index = (index < 0)? canaisCadastrados.size() + index: index;
        setCanalAtual(this.canaisCadastrados.get(index));
    }

    /**
     * informar dados: mostra o canal atual (nome, número e se é HD) e o volume atual.
     */
    public  void informarDados(){
        System.out.println(toString());
    }

    /**
     * mostrar grade: apresenta a lista ordenada de canais disponíveis, mostrando todos os
     * dados de cada canal. Ordenados pelo numero do canal.
     */
    public void mostarGrade() {
        System.out.println(this.getClass().getSimpleName() + "{id=" + id + ", volume="+ volume +  ", canalAtual=" + canalAtual + "}");
        // Ordenados pelo numero do canal.
        this.canaisCadastrados.stream().sorted(Comparator.comparing(Canal::getNumero)).
                forEach(canal -> System.out.println("\t" + canal));
    }

    @Override
    public String toString() {
        return "Televisao{" +
                "id='" + id + '\'' +
                ", volume=" + volume +
                ", canalAtual=" + canalAtual +
                '}';
    }
}
