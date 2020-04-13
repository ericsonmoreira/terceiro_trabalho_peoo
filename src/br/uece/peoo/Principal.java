package br.uece.peoo;

import br.uece.peoo.exceptions.TvJaCadastradaException;
import br.uece.peoo.model.*;
import br.uece.peoo.util.Menu;

import java.util.*;

/**
 * Crie uma classe Principal na qual vários canais são criados (varie entre HDs e não HDs).
 * Em seguida, crie pelo menos 2 TVs (uma de cada tipo), e cadastre os canais criados. Crie
 * um objeto do controle remoto, associe a ele as TVs criadas, e ofereça ao usuário um menu
 * com as opções disponíveis. Toda vez que o usuário escolhe uma opção, o método
 * correspondente nas TVs é executado e o resultado é apresentado no console.
 */
public class Principal {

    public static ArrayList<Canal> CANAIS; // Lista de Canais

    public static SmartTV smartTV; // smartTV

    public static TVHD tvhd; // televisão HD

    public static ControleRemoto controleRemoto; // controleRemoto

    public static void main(String[] args) {
        init(); // iniciando as variáveis.

        Menu menu = new Menu();

        menu.addOption(1, "(+) Volume", () -> aumentarVolumeMenu());
        menu.addOption(2, "(-) Volume", () -> diminuirVolumeMenu());
        menu.addOption(3, "(+) Canal", () -> proximoCanalMenu());
        menu.addOption(4, "(-) Canal", () -> anteriorCanalMenu());
        menu.addOption(5, "Sintonizar Canal", () -> sintonizarMenu());
        menu.addOption(6, "Informar Dados", () -> controleRemoto.informarDados());
        menu.addOption(7, "Mostrar Grades", () -> controleRemoto.mostrarGrade());

        // opção para sair do programa
        menu.addOption(99, "Sair do Programa", () -> System.exit(0));

        // mostrar a grade
        controleRemoto.mostrarGrade();

        // loop do programa
        while (true) {
            Scanner scanner = new Scanner(System.in);
            menu.printMenu();
            System.out.println("Digite a opção:");
            try {
                int op = scanner.nextInt();
                menu.getRunnable(op).run();
            } catch (InputMismatchException | NullPointerException err) {
                System.err.println("Opção invalida");
            }
        }
    }

    /**
     * Inicializando variáveis.
     */
    public static void init() {
        CANAIS = new ArrayList<Canal>();
        // criando canais
        // canais não HD
        CANAIS.add(new Canal(10, "Globo", false));
        CANAIS.add(new Canal(20, "SBT", false));
        CANAIS.add(new Canal(30, "RedeTv", false));
        CANAIS.add(new Canal(40, "Band", false));
        CANAIS.add(new Canal(50, "Record", false));
        CANAIS.add(new Canal(60, "CNN", false));
        // canais HD
        CANAIS.add(new Canal(110, "GloboHD", true));
        CANAIS.add(new Canal(120, "SBTHD", true));
        CANAIS.add(new Canal(130, "RedeTvHD", true));
        CANAIS.add(new Canal(140, "BandHD", true));
        CANAIS.add(new Canal(150, "RecordHD", true));
        CANAIS.add(new Canal(160, "CNNHD", true));

        controleRemoto = new ControleRemoto();

        smartTV = new SmartTV("PHILCO1010", CANAIS);
        tvhd = new TVHD("HPHDTV2020", CANAIS);

        smartTV.cadastrarCanais(CANAIS);
        tvhd.cadastrarCanais(CANAIS);

        try {
            // adicionando as TVs ao ControleRemoto
            controleRemoto.addTv(smartTV);
            controleRemoto.addTv(tvhd);
            // controleRemoto.addTv(tvhd); // aqui ocorre uma TvJaCadastradaException
        } catch (TvJaCadastradaException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Aumenta o volume em uma unidade para cada Tv e mostra o volume atual de cada uma.
     */
    public static void aumentarVolumeMenu() {
        controleRemoto.aumentarVolume();
        controleRemoto.getTVs().forEach(
                tv -> System.out.println("{Tv id: " + tv.getId() + ", Volume: " + tv.getVolume() + "}")
        );
        System.out.println("Volumes alterados com sucesso");
    }

    /**
     * Diminui o volume em uma unidade para cada Tv e mostra o volume atual de cada uma.
     */
    public  static void diminuirVolumeMenu() {
        controleRemoto.diminuirVolume();
        controleRemoto.getTVs().forEach(
                tv -> System.out.println("{Tv id: " + tv.getId() + ", Volume: " + tv.getVolume() + "}")
        );
        System.out.println("Volumes alterados com sucesso");
    }

    /**
     * Muda o canal atual de cada Tv para o próximo canal dos canais cadastrados da Tv respectiva.
     */
    public static void proximoCanalMenu() {
        controleRemoto.proximoCanal();
        controleRemoto.getTVs().forEach(
                tv -> System.out.println("{Tv id: " + tv.getId() + ", Canal Atual: " + tv.getCanalAtual() + "}")
        );
        System.out.println("Canais Atuais alterados com sucesso");
    }

    /**
     * Muda o canal atual de cada Tv para o canal anterior dos canais cadastrados da Tv respectiva.
     */
    public static void anteriorCanalMenu() {
        controleRemoto.anteriorCanal();
        controleRemoto.getTVs().forEach(
                tv -> System.out.println("{Tv id: " + tv.getId() + ", Canal Atual: " + tv.getCanalAtual() + "}")
        );
        System.out.println("Canais Atuais alterados com sucesso");
    }

    /**
     * Mostra a lista de canais disponíveis e (tenta) altera o canal atual de cada
     * Tv do controle remoto de acordo com o canal escolhido. Caso uma tv do controle
     * remoto não tenha o canal desejado em sua lista de canais cadastrados, mostra
     * uma mensagem de erro.
     */
    public static void sintonizarMenu() {
        // mostra os canais disponíveis.
        System.out.println("Canais");
        CANAIS.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do Canal desejado");
        int numCanal = scanner.nextInt();
        // para cada tv cadastrada do controle remoto, sintonizar o canal escolhido
        Optional<Canal> optionalCanal = CANAIS.stream().filter(c -> c.getNumero() == numCanal).findFirst();
        optionalCanal.ifPresentOrElse(
                canal -> controleRemoto.sintonizarCanal(canal),
                () -> System.err.println("Canal inválido")
        );
        controleRemoto.getTVs().forEach(
                tv -> System.out.println("{Tv id: " + tv.getId() + ", Canal Atual: " + tv.getCanalAtual() + "}")
        );
    }

}
