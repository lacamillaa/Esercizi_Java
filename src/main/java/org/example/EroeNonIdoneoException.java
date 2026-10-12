package org.example;

public class EroeNonIdoneoException extends Exception {
    public EroeNonIdoneoException(String nome, Integer diff, Integer pow) {
        super("Richiesto eroe di potenza " + diff + ". " +
                nome + "(potenza " + pow + ") non è idoneo.");
    }
}
