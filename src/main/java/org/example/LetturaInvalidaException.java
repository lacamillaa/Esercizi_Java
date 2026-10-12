package org.example;

public class LetturaInvalidaException extends Exception {
    public LetturaInvalidaException(Integer umidita) {
        super("[ERRORE] Il valore " + umidita + " non è compreso tra 0 e 100");
    }
}
