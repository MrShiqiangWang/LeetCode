package history.pkg202007;

import java.util.HashMap;
import java.util.Map;

public class L172 {

    public static void main(final String[] args) {
        System.out.println(new L172().trailingZeroes(5));
    }

    public int trailingZeroes(final int n) {
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        int s, m;
        for (int i = 1; i <= n; i++) {
            s = i;
            m = 0;
            while (s % 5 == 0 && n != 0) {
                if (map.containsKey(s)) {
                    m += map.get(s);
                    break;
                }
                m++;
                s = s / 5;
            }
            if (m != 0 && !map.containsKey(i)) {
                map.put(i, m);
            }
            counter += m;
        }
        return counter;
    }

}
