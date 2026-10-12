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
            println("Saldo attuale: " + cb.getSaldo() + "EUR");
        }

        // ImportoNonValidoException (unchecked)
        try {
            cb.Preleva(-20.00);
        } catch (ImportoNonValidoException e) {
            println(e.getMessage());
        }

        cb.Preleva(20.00);

        /* String input = "";
        try {
            input = readln("Inserisci importo da prelevare: ");
            Double value = Double.parseDouble(input);
            cb.Preleva(value);
        } catch (NumberFormatException e) {
            println("Valore numerico non valido: " + input);
        } catch (Exception e) {
            println(e.getMessage());
        } */
    }
}
