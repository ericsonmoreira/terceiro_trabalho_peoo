package br.uece.peoo;

import br.uece.peoo.model.*;
import br.uece.peoo.util.Menu;

import java.sql.Array;
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

    /**
     * Iniciando os canais, as
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
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        init(); // iniciando as variáveis.

        Menu menu = new Menu();

        menu.addOption(1, "+ Volume", () -> controleRemoto.aumentarVolume());
        menu.addOption(2, "- Volume", () -> controleRemoto.diminuirVolume());
        menu.addOption(3, "+ Canal", () -> controleRemoto.proximoCanal());
        menu.addOption(4, "- Canal", () -> controleRemoto.mostrarGrade());
        menu.addOption(5, "- Canal", () -> controleRemoto.mostrarGrade());
        menu.addOption(6, "Mostrar Grade", () -> sintonizarMenu());

        // opção para sair do programa
        menu.addOption(99, "Sair do Programa", () -> System.exit(0));

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
     * Mostra a lista de canais disponíveis e (tenta) altera o canal atual de cada
     * Tv do controle remoto.
     */
    public static void sintonizarMenu() {
        // TODO implementar.
        // mostra os canais disponíveis.
        // pega o numero do canal escolhido --- verificar aqui se o numéro é de um canal possivel
        // para cada tv cadastrada do controle remoto, sintonizar o canal escolhido
    }

}
