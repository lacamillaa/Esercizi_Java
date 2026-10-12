package org.example;

import java.util.*;

public class HTTPManager {
    private static int len = 0;
    private static ArrayList<RichiestaHTTP> richieste = new ArrayList<>();
    private static LinkedList<RichiestaHTTP> ultime10 = new LinkedList<>();
    private static HashSet<String> ipSospetti = new HashSet<>();

    public static void InserisciRichiesta(RichiestaHTTP richiestaHTTP) {
        len++;
        richieste.add(richiestaHTTP);
        ultime10.addLast(richiestaHTTP);
        if (len > 10) {
            ultime10.removeFirst();
        }
        if (richiestaHTTP.getStatusCode() / 100 == 4
                || richiestaHTTP.getStatusCode() / 100 == 5) {
            ipSospetti.add(richiestaHTTP.getIP());
        }
    }

    public static Iterator<RichiestaHTTP> Status500(int N) {
        List<RichiestaHTTP> res = richieste.stream().filter((
                richiestaHTTP -> richiestaHTTP.getStatusCode() >= 500
        )).toList().subList(0, 10);
        return res.iterator();
    }
}
