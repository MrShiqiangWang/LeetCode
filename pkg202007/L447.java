package pkg202007;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L447 {

    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> record = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = getDistance(points[i], points[j]);
                    record.put(distance, record.getOrDefault(distance, 0) + 1);
                }
            }
            for (Entry<Integer, Integer> entry : record.entrySet()) {
                if (entry.getValue() > 1) {
                    sum += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return sum;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
