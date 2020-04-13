package br.uece.peoo.model;

import br.uece.peoo.exceptions.CanalInexitenteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe abstrata para representar uma Televisao.
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

    protected String id;

    protected int volume;

    protected Canal canalAtual;

    protected ArrayList<Canal> canaisCadastrados;

    protected ArrayList<Canal> canaisDisponiveis;

    public String getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    /**
     * Muda o volume da TV. O volume da tv não deve estar entre VOL_MAX e VOL_MIN.
     * @param voloume
     */
    public void setVolume(int volume) {
        this.volume = (volume > VOL_MAX || volume < VOL_MIN ? this.volume: volume);
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }

    /**
     * Construtor padrão da classe.
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
      Alterar o volume da tv.
     * @param COMANDOVOLTV {@link COMANDO_TV} UP_VOL ou DOWN_VOL.
     */
    public void alterarVolume(COMANDO_TV COMANDOVOLTV){
        setVolume(getVolume() + COMANDOVOLTV.valor);
    }

    /**
     * Cadastra canais a
     * @param canais
     */
    public abstract void cadastrarCanais(List<Canal> canais);

    /**
     * Recebe como um parâmetro um canal e retorna verdadeiro, caso o canal já exista na
     * programação da TV, e falso caso contrário.
     * @param canal Canal a ser procurardo na programação da TV
     * @return
     */
    public boolean verificarCanalExistente(Canal canal) {
        return this.canaisCadastrados.contains(canal);
    }

    /**
     * Busca na lista de canais o canal com esse número e, caso exista, altera o canal
     * atual para este. Caso não exista, dispara uma exceção de canal inexistente
     * @param num número do canal a ser procurado.
     * @throws CanalInexitenteException exception disparada quando o canal
     * não está entre os canais cadastrados.
     */
    public void sintonizar(int num) throws CanalInexitenteException {
        // tenta encontrar o canal nos canais cadastrados.
        Canal canalPossivel = this.canaisCadastrados.stream().
                filter(canal -> canal.getNumero() == num).findFirst().orElse(null);
        if (verificarCanalExistente(canalPossivel)) {
            this.canalAtual = canalPossivel;
        } else { // se não encontrar, dispara essa exception
            throw new CanalInexitenteException("Canal não cadastrado.", num, this);
        }
    }

    /**
     * recebe como parâmetro “próximo” ou “anterior” e altera o canal atual de acordo com o parâmetro solicitado.
     * Se o canal atual for o último da lista e for solicitado próximo canal, deve-se voltar ao início da lista.
     * Já se for o primeiro canal e solicitar o anterior, deve-se pular para o último canal da lista.
     * @param comando proximo -> {@link COMANDO_TV}
     */
    public void alterarCanal(COMANDO_TV comando){
        // pega a posicao do canal atual na lista de canais cadastrados.
        int index = canaisCadastrados.indexOf(this.canalAtual);
        index = (index + comando.valor) % canaisCadastrados.size();
        index = (index < 0) ? canaisCadastrados.size() + index: index;
        setCanalAtual(this.canaisCadastrados.get(index));
    }

    /**
     * Mostra os dados do canal atual (nome, número e se é HD) e do volume.
     */
    public  void informarDados(){
        System.out.println(canalAtual);
    }

    /**
     * Apresenta a lista ordenada por número de canais disponíveis, mostrando
     * todos os dados de cada canal.
     */
    public void mostarGrade() {
        // Mostrando antes as informações da Tv para poder visualizar melhor.
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
