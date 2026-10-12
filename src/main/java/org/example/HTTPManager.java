package org.example;

import java.util.*;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class HTTPManager {
    private static int len = 0;
    private static ArrayList<RichiestaHTTP> richieste = new ArrayList<>();
    private static LinkedList<RichiestaHTTP> ultime10 = new LinkedList<>();
    private static HashSet<String> ipSospetti = new HashSet<>();
    private static TreeSet<Long> tempiRisp = new TreeSet<>();

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
        tempiRisp.add(richiestaHTTP.getTempoRispostaMs());
    }

    public static Iterator<RichiestaHTTP> Status500(int N) {
        List<RichiestaHTTP> res = richieste.stream().filter((
                richiestaHTTP -> richiestaHTTP.getStatusCode() >= 500
        )).toList().subList(0, 10);
        return res.iterator();
    }

    public static Long Percentile90() {
        int sz = tempiRisp.size();
        int percentilePos = (int)(Math.ceil(0.9 * sz) - 1);
        Iterator<Long> it = tempiRisp.iterator();
        for (int i = 0; i < percentilePos && it.hasNext(); i++) {
            it.next();
        }
        return it.hasNext() ? it.next() : null;
    }

    public static void PrintReport() {
        println("=> IP sospetti: ");
        for (String ip : ipSospetti) {
            println("\t" + ip);
        }
        println("=> Ultime 10 richieste: ");
        for (RichiestaHTTP richiesta : ultime10) {
            println("\t" + richiesta.brief());
        }
        Long perc90 = Percentile90();
        println("=> Il percentile 90 è corrispondente a " + perc90 + "ms");
    }

    public static void PrintRequests(Boolean brief) {
        for (RichiestaHTTP r : richieste) {
            println(brief ? r.brief() : r);
        }
    }

    public static void PrintLast10Requests(Boolean brief) {
        for (RichiestaHTTP r : ultime10) {
            println(brief ? r.brief() : r);
        }
    }
}
