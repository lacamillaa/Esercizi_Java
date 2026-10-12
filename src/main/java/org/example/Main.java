package org.example;

import java.util.*;

public class Main {
    static void main() {
        for (int i = 0; i < 30; i++) {
            // genera una richiesta
            String finalIP = "";
            for (int j = 0; j < 4; j++) {
                finalIP += Integer.valueOf(new Random().nextInt(0, 256)).toString();
                if (j < 3) finalIP += ".";
            }
            String[] paths = {
                    "/index.html",
                    "/login.html",
                    "/info.html"
            };
            String path = paths[new Random().nextInt(0, paths.length)];
            var codeArr = RichiestaHTTP.CodeMap.keySet();
            Iterator<Integer> it = codeArr.iterator();
            int target = new Random().nextInt(0, codeArr.size());
            for (int j = 0; j < target; j++) {
                it.next();
            }
            Integer code = it.next();
            Long tempoRisp = new Random().nextLong(100);
            Long timestamp = new Random().nextLong(Long.MAX_VALUE);
            RichiestaHTTP req = new RichiestaHTTP(finalIP, path, code, tempoRisp, timestamp);
            HTTPManager.InserisciRichiesta(req);
        }
        HTTPManager.PrintReport();
        HTTPManager.PrintLast10Requests(true);
        HTTPManager.PrintRequests(false);
    }
}
