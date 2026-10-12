package org.example;

import java.util.*;

public class HTTPManager {
    private static ArrayList<RichiestaHTTP> richieste = new ArrayList<>();

    public static void InserisciRichiesta(RichiestaHTTP richiestaHTTP) {
        richieste.add(richiestaHTTP);
    }

    public static Iterator<RichiestaHTTP> Status500(int N) {
        List<RichiestaHTTP> res = richieste.stream().filter((
                richiestaHTTP -> richiestaHTTP.getStatusCode() >= 500
        )).toList().subList(0, 10);
        return res.iterator();
    }
}
