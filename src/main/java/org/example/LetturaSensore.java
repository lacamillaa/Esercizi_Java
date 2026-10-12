package org.example;

public class LetturaSensore {
    private Double temperatura = null;
    private Integer umiditaPercentuale = null;
    private Long timestampUnix = null;
    private Boolean batteriaScarica = null;

    public LetturaSensore(Double temperatura, Integer umiditaPercentuale, Long timestampUnix, Boolean batteriaScarica) {
        this.temperatura = temperatura;
        this.umiditaPercentuale = umiditaPercentuale;
        this.timestampUnix = timestampUnix;
        this.batteriaScarica = batteriaScarica;
    }
}
