package org.example;
import static java.lang.IO.*;

public class Main{
    static void main () throws SaldoInsufficienteException {
        ContoBancario cb = new ContoBancario(100.00);
        // SaldoInsufficienteException (checked)
        try {
            cb.Preleva(200.00);
        } catch (SaldoInsufficienteException e) {
            println(e.getMessage());
        } finally {
            println(cb.getSaldo());
        }

        // ImportoNonValidoException (unchecked)
        try {
            cb.Preleva(-20.00);
        } catch (ImportoNonValidoException e) {
            println(e.getMessage());
        }

        // importo valido
        cb.Preleva(20.00);
    }
}
