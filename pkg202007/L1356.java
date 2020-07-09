package pkg202007;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L1356 {

    private static class Temp {

        int number = -1;
        int oneCounter = 0;
    }

    public int[] sortByBits(int[] arr) {

        List<Temp> temps = new ArrayList<Temp>();
        for (int i = 0; i < arr.length; i++) {
            char[] cs = new BigInteger(String.valueOf(arr[i]), 10).toString(2).toCharArray();
            int counter = 0;
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == '1') {
                    counter++;
                }
            }
            Temp temp = new Temp();
            temp.number = arr[i];
            temp.oneCounter = counter;
            temps.add(temp);
        }
        Collections.sort(temps, new Comparator<Temp>() {

            @Override
            public int compare(Temp o1, Temp o2) {
                int value = Integer.valueOf(o1.oneCounter).compareTo(Integer.valueOf(o2.oneCounter));
                if (value != 0) {
                    return value;
                }
                return Integer.valueOf(o1.number).compareTo(Integer.valueOf(o2.number));
            }
        });
        int[] result = new int[arr.length];
        for (int i = 0; i < temps.size(); i++) {
            result[i] = temps.get(i).number;
        }
        return result;
    }
}
