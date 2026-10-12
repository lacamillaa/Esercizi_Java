package org.example;

import static java.lang.IO.println;

public class ContoBancario {
    private Double Saldo;

    public ContoBancario(Double saldo) {
        Saldo = saldo;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void Preleva(Double prelievo) throws SaldoInsufficienteException {
        if (prelievo < Saldo) {
            throw new SaldoInsufficienteException(prelievo, Saldo);
        }
        Saldo -= prelievo;
        println("Saldo attuale: " + Saldo + "EUR");
    }
}
