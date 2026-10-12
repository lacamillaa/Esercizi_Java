package org.example;

public class RichiestaHTTP {
    private String IP;
    private String path;
    private Integer statusCode;
    private Long tempoRispostaMs;
    private Long timestamp;

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
}
