package history.pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L447_1 {

    public int numberOfBoomerangs(final int[][] points) {
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                final int distance = this.getDistance(points[i], points[j]);
                // 距离1
                final Map<Integer, Integer> map2 = map.getOrDefault(i, new HashMap<>());
                map2.put(distance, map2.getOrDefault(distance, 0) + 1);
                map.put(i, map2);
                // 距离2
                final Map<Integer, Integer> map3 = map.getOrDefault(j, new HashMap<>());
                map3.put(distance, map3.getOrDefault(distance, 0) + 1);
                map.put(j, map3);
            }
            final Map<Integer, Integer> myMap = map.getOrDefault(i, new HashMap<>());
            for (final Entry<Integer, Integer> entry : myMap.entrySet()) {
                if (entry.getValue() > 1) {
                    sum += (entry.getValue()) * (entry.getValue() - 1);
                }
            }
        }
        return sum;
    }

    private int getDistance(final int[] p1, final int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
