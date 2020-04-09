package br.uece.peoo;

import br.uece.peoo.model.Canal;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final List<Canal> CANAIS = Arrays.asList(
            // canais não HD
            new Canal(10, "Globo", false),
            new Canal(20, "SBT", false),
            new Canal(30, "RedeTv", false),
            new Canal(40, "Band", false),
            new Canal(50, "Record", false),
            new Canal(60, "CNN", false),
            // canais HD
            new Canal(110, "GloboHD", true),
            new Canal(120, "SBTHD", true),
            new Canal(130, "RedeTvHD", true),
            new Canal(140, "BandHD", true),
            new Canal(150, "RecordHD", true),
            new Canal(160, "CNNHD", true)
    );

    public static void main(String[] args) {
        System.out.printf("testar aqui");
    }
}
