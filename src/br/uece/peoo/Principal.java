package br.uece.peoo;

import br.uece.peoo.exceptions.TvJaCadastradaException;
import br.uece.peoo.model.Canal;
import br.uece.peoo.model.ControleRemoto;
import br.uece.peoo.model.SmartTV;
import br.uece.peoo.model.TVHD;
import br.uece.peoo.view.ControleRemotoJFrame;

import javax.swing.*;
import java.util.ArrayList;

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
        init(); // Inicinado as variáveis.
        JFrame frame = new ControleRemotoJFrame(controleRemoto, CANAIS);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }

    /**
     * Inicializando variáveis.
     */
    public static void init() {
        CANAIS = new ArrayList<>();
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

}
