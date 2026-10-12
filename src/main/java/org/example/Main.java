package org.example;

import java.util.Optional;

import static java.lang.IO.*;

public class Main {
    static void main() {
        String[] pacchetti = {
                "temp=23.5;umid=61;ts=1732000000;batt_low=false",
                "temp=xxuyf;umid=136;ts=24682535",
                "umid=10;ts=325452134;batt_low=true",
                "temp=17;ts=456727xgt7e8;batt_low=syetydtre",
                "umid=24;temp=253;ts=6776432222;batt_low=false",
                "random_field=25764",
                "temp=56;ts=342647589321",
                "umid=244;ts=251535453;temp=11",
        };
        for (String pacchetto : pacchetti) {
            try {
                Optional<LetturaSensore> ls = LetturaSensore.ParsePacchetto(pacchetto);
                if (ls.isEmpty()) {
                    println("[WARNING] Impossibile leggere pacchetto: " + pacchetto);
                }
            } catch (LetturaInvalidaException e) {
                println(e.getMessage());
            }
        }
    }
}
