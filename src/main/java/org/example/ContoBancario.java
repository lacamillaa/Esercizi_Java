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
        println("Prelievo di " + prelievo + "EUR in corso...");
        if (prelievo <= 0) {
            throw new ImportoNonValidoException(prelievo);
        }
        if (Saldo < prelievo) {
            throw new SaldoInsufficienteException(prelievo, Saldo);
        }
        Saldo -= prelievo;
        println("Saldo attuale: " + Saldo + "EUR");
    }
}
