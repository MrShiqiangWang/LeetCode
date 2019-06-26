package findradius;

import java.util.Arrays;
import java.util.LinkedList;

public class FindRadius {

    class HouseAndHeater {

        boolean house;

        int position;
    }

    public int findRadius(int[] houses, int[] heaters) {
        // 对于每个房子
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int headerLength=heaters.length;
        int max = 0;
        int res = 0;
        for (int house : houses) {
            if (house > heaters[headerLength - 1]) {
                max = Math.max(max, house - heaters[headerLength - 1]);
                continue;
            }

            if (house < heaters[0]) {
                max = Math.max(max, heaters[0] - house);
                continue;
            }
            for (int i = res; i < headerLength - 1; i++) {
                if (house >= heaters[i] && house <= heaters[i + 1]) {
                    int tmp = Math.min(house - heaters[i], heaters[i + 1] - house);
                    max = Math.max(max, tmp);
                    res = i;
                }
            }

        }
        return max;
    }

    public int abs(int x, int y) {
        int distance = 0;
        if (x - y >= 0) {
            distance = x - y;
        }
        else {
            distance = y - x;
        }
        return distance;
    }

    public int findRadiuslow(int[] houses, int[] heaters) {
        // 求每个房屋和最近的热水器之间的最大距离
        int max = 0;
        int distances[] = new int[houses.length];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        // 每个房子到最近热水器之间的距离
        for (int i = 0; i < houses.length; i++) {
            for (int j = 0; j < heaters.length; j++) {
                int distance = 0;
                if (houses[i] - heaters[j] >= 0) {
                    distance = houses[i] - heaters[j];
                }
                else {
                    distance = heaters[j] - houses[i];
                }
                if (distances[i] == -1) {
                    distances[i] = distance;
                }
                if (distances[i] > distance) {
                    distances[i] = distance;
                }
            }
        }
        // 求出距离的最大值
        for (int i = 0; i < distances.length; i++) {
            if (max < distances[i]) {
                max = distances[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] houses = { 1, 2, 3, 5, 15 };
        int[] heaters = { 2, 30 };
        System.out.println(new FindRadius().findRadius(houses, heaters));
    }
}
