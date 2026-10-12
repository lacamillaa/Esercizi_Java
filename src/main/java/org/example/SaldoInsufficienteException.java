package org.example;

// eccezione checked: deve essere gestita da ogni metodo nello StackTrace
public class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(Double prelievo, Double saldo) {
        super("Impossibile prelevare " + prelievo + "EUR." +
                "Deficit: " + (saldo - prelievo) + "EUR");
    }
}
