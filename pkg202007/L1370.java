package pkg202007;

import java.util.Map.Entry;
import java.util.TreeMap;

public class L1370 {

    public static void main(String[] args) {
        System.out.println(new L1370().sortString("aaaabbbbcccc"));
    }

    public String sortString(String s) {
        char[] cs = s.toCharArray();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }

        boolean asc = true;
        StringBuilder builder = new StringBuilder();
        while (true) {
            StringBuilder suBuilder = new StringBuilder();
            boolean has = false;
            for (Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 0) {
                    has = true;
                    suBuilder.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                }
            }
            if (has == false) {
                return builder.toString();
            }

            if (!asc) {
                builder.append(suBuilder.reverse().toString());
            }
            else {
                builder.append(suBuilder.toString());
            }
            asc = !asc;
        }
    }
}
