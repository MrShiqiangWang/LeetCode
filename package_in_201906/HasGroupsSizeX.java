package package_in_201906;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HasGroupsSizeX {

    public static void main(String[] args) {
        int[] deck = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(deck));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        // 小于2 返回失败
        if (deck.length < 2) {
            return false;
        }

        // 对每个数字计�?
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 分数字计�?
        for (int i = 0; i < deck.length; i++) {
            // 包含数字
            if (map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            }
            else {
                map.put(deck[i], 1);
            }
        }

        // 对于每个数字找最大个�?
        int min = 0;

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (min == 0) {
                min = entry.getValue();
            }
            min = Math.min(entry.getValue(), min);
        }
        if (min < 2) {
            return false;
        }

        // 球从2 到max的最大公约数，如果找到，那么显示true，否则，显示false
        for (int i = 2; i <= min; i++) {
            boolean find = true;
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % i != 0) {
                    find = false;
                }
            }
            if (find) {
                return true;
            }
        }
        return false;
    }

}
