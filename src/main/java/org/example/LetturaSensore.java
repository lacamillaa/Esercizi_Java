package org.example;

import static java.lang.IO.*;
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

    public static Optional<LetturaSensore> ParsePacchetto(String raw) {
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
                        Double _d = Double.parseDouble(value);
                        ls.setTemperatura(_d);
                        fieldsFound++;
                        break;
                    case "umid":
                        Integer _i = Integer.parseInt(value);
                        ls.setUmiditaPercentuale(_i);
                        fieldsFound++;
                        break;
                    case "ts":
                        Long _l = Long.parseLong(value);
                        ls.setTimestampUnix(_l);
                        fieldsFound++;
                        break;
                    case "batt_low":
                        Boolean _b = Boolean.parseBoolean(value);
                        ls.setBatteriaScarica(_b);
                        fieldsFound++;
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                println("[ERRORE] " + e.getMessage());
            }
        }
        if (fieldsFound == 0) return Optional.empty();
        return Optional.of(ls);
    }
}
