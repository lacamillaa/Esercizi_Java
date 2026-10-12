package org.example;

import net.datafaker.Faker;

import java.util.Random;

import static java.lang.IO.println;

public class Reclutatore {
    private Integer Difficolta;

    public Reclutatore(Integer difficolta) {
        Difficolta = difficolta;
    }

    public void GeneraEroe() {
        Faker gen = new Faker();
        var supereroe = gen.superhero();
        String nome = supereroe.name();
        Integer power = new Random().nextInt(0, 101);
        println(nome + "(potenza " + power + ") è pronto per salvare il mondo!");
    }
}
