package org.example;

import static java.lang.IO.*;

public class Main {
    static void main() {
        String[] pacchetti = {
                "temp=23.5;umid=61;ts=1732000000;batt_low=false",
                "temp=xxuyf;umid=136;ts=24682535",
                "umid=10;ts=325452134;batt_low=true",
                "temp=17;ts=456727xgt7e8;batt_low=syetydtre",
                "umid=24;temp=253;ts=6776432222;batt_low=false",
                "batt_low=true",
                "temp=56;ts=342647589321",
                "umid=244;ts=251535453;temp=11",
        };
        for (String pacchetto : pacchetti) {
            try {
                LetturaSensore.ParsePacchetto(pacchetto);
            } catch (LetturaInvalidaException e) {
                println(e.getMessage());
            }
        }
    }
}
