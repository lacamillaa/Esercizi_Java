package org.example;

import java.util.*;

public class RichiestaHTTP {
    private String IP;
    private String path;
    private Integer statusCode;
    private Long tempoRispostaMs;
    private Long timestamp;

    private static Map<Integer, String> CodeMap = Map.ofEntries(
            Map.entry(200, "OK"),
            Map.entry(201, "CREATED"),
            Map.entry(204, "NO CONTENT"),
            Map.entry(301, "MOVED PERMANENTLY"),
            Map.entry(400, "BAD REQUEST"),
            Map.entry(401, "UNAUTHORIZED"),
            Map.entry(403, "FORBIDDEN"),
            Map.entry(404, "NOT FOUND"),
            Map.entry(405, "METHOD NOT ALLOWED"),
            Map.entry(429, "TOO MANY REQUESTS"),
            Map.entry(500, "INTERNAL SERVER ERROR")
    );

    public RichiestaHTTP(String IP, String path, Integer statusCode,
                         Long tempoRispostaMs, Long timestamp) {
        this.IP = IP;
        this.path = path;
        this.statusCode = statusCode;
        this.tempoRispostaMs = tempoRispostaMs;
        this.timestamp = timestamp;
    }

    public String getIP() {
        return IP;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Long getTempoRispostaMs() {
        return tempoRispostaMs;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        String res = "[" + this.hashCode() + "] " + this.getIP()
                + "\n\tPath: " + this.getPath()
                + "\n\tStatus Code: " + this.getStatusCode();
        if (CodeMap.containsKey(this.getStatusCode())) {
            res += " " + CodeMap.get(this.getStatusCode());
        }
        res += "\n\tTempo risposta: " + this.getTempoRispostaMs() + "ms"
                + "\n\tTimestamp: " + new Date(this.getTimestamp());
        return res;
    }
}
