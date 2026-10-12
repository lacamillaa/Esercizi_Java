package org.example;

public class ImportoNonValidoException extends RuntimeException {
    public ImportoNonValidoException(Double prelievo) {
        super("Prelievo non valido: " + prelievo + "EUR");
    }
}
