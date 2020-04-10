package br.uece.peoo;

import br.uece.peoo.model.*;
import br.uece.peoo.util.Menu;

import java.sql.Array;
import java.util.*;

public class Main {

    public static ControleRemoto controleRemoto;

    public static ArrayList<Canal> CANAIS;

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

        SmartTV smartTV = new SmartTV("PHILCO1010", CANAIS);
        TVHD tvhd = new TVHD("HPHDTV2020", CANAIS);

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
        menu.addOption(5, "Mostrar Grade", () -> controleRemoto.mostrarGrade());

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

}
