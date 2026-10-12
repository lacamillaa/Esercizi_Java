package org.example;

import java.util.*;

public class HTTPManager {
    private static int len = 0;
    private static ArrayList<RichiestaHTTP> richieste = new ArrayList<>();
    private static LinkedList<RichiestaHTTP> ultime10 = new LinkedList<>();

    public static void InserisciRichiesta(RichiestaHTTP richiestaHTTP) {
        len++;
        richieste.add(richiestaHTTP);
        ultime10.addLast(richiestaHTTP);
        if (len > 10) {
            ultime10.removeFirst();
        }
    }

    public static Iterator<RichiestaHTTP> Status500(int N) {
        List<RichiestaHTTP> res = richieste.stream().filter((
                richiestaHTTP -> richiestaHTTP.getStatusCode() >= 500
        )).toList().subList(0, 10);
        return res.iterator();
    }
}
