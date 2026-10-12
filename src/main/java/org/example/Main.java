package org.example;

import static java.lang.IO.*;

public class Main {
    static void main() {
        Reclutatore r = new Reclutatore(75);
        for (int i = 0; i < 5; i++) {
            // tentativi di recluta
            try {
                println("Generazione di un candidato adeguato...");
                r.GeneraEroe();
            } catch (EroeNonIdoneoException e) {
                println(e.getMessage());
            }
            println();
        }
    }
}
