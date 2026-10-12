package org.example;

import static java.lang.IO.*;

import java.util.*;
import java.util.Optional;

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

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmiditaPercentuale(Integer umiditaPercentuale) {
        this.umiditaPercentuale = umiditaPercentuale;
    }

    public void setTimestampUnix(Long timestampUnix) {
        this.timestampUnix = timestampUnix;
    }

    public void setBatteriaScarica(Boolean batteriaScarica) {
        this.batteriaScarica = batteriaScarica;
    }

    public static Optional<LetturaSensore> ParsePacchetto(String raw) throws LetturaInvalidaException {
        // esegui il parsing di tutti i campi
        // se nessun campo è stato individuato, restituisci null
        LetturaSensore ls = new LetturaSensore(null, null,
                null, null);
        String[] fields = raw.split(";");
        Integer fieldsFound = 0;
        for (String field : fields) {
            // dividi in chiave e valore
            Integer splitPos = field.indexOf("=");
            if (splitPos == -1) {
                continue;
            }
            String key = field.substring(0, splitPos);
            String value = field.substring(splitPos + 1);
            try {
                switch (key) {
                    case "temp":
                        double _d = Double.parseDouble(value);
                        ls.setTemperatura(_d);
                        fieldsFound++;
                        break;
                    case "umid":
                        int _i = Integer.parseInt(value);
                        if (_i < 0 || _i > 100) {
                            throw new LetturaInvalidaException(_i);
                        }
                        ls.setUmiditaPercentuale(_i);
                        fieldsFound++;
                        break;
                    case "ts":
                        long _l = Long.parseLong(value);
                        ls.setTimestampUnix(_l);
                        fieldsFound++;
                        break;
                    case "batt_low":
                        boolean _b = Boolean.parseBoolean(value);
                        ls.setBatteriaScarica(_b);
                        fieldsFound++;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                println("[ERRORE] Valore numerico non valido: " + e.getMessage());
            }
        }
        if (fieldsFound == 0) return Optional.empty();
        return Optional.of(ls);
    }

    @Override
    public String toString() {
        String res = "[" + (this.hashCode()) + "] ";
        if (this.temperatura != null) {
            res += ("\n\tTemperatura: " + this.temperatura);
        }
        if (this.umiditaPercentuale != null) {
            res += ("\n\tUmidità: " + this.umiditaPercentuale + "%");
        }
        if (this.timestampUnix != null) {
            res += ("\n\tTimestamp: " + new Date());
        }
        if (this.batteriaScarica != null) {
            res += ("\n\tBatteria scarica: " + (this.batteriaScarica ? "SI" : "NO"));
        }
        return res;
    }
}
