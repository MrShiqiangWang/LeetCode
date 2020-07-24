package pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L299 {

    public String getHint(final String secret, final String guess) {
        final char[] sc = secret.toCharArray();
        final char[] gc = guess.toCharArray();
        int bullCounter = 0;
        int cowCounter = 0;
        int i = 0, j = 0;
        final int scleng = sc.length, gcleng = gc.length;
        final Map<Character, Integer> s = new HashMap<Character, Integer>();
        final Map<Character, Integer> g = new HashMap<>();
        while (i < scleng || j < gcleng) {
            if (i < scleng && j < gcleng && sc[i] == gc[j]) {
                bullCounter++;
                i++;
                j++;
                continue;
            }
            if (i < scleng) {
                s.put(sc[i], s.getOrDefault(sc[i], 0) + 1);
                i++;
            }
            if (j < gcleng) {
                g.put(gc[j], g.getOrDefault(gc[j], 0) + 1);
                j++;
            }
        }

        Character key;
        Integer value;
        int gcounter;
        for (final Entry<Character, Integer> entry : s.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            gcounter = g.getOrDefault(key, 0);
            if (gcounter >= value) {
                cowCounter += value;
                continue;
            }
            cowCounter += gcounter;
        }
        return new StringBuilder().append(bullCounter).append('A').append(cowCounter).append('B').toString();
    }
}
