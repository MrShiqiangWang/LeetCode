package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayHelper {

    public static int[] stringToArray(String str) {
        List<Integer> result = Arrays.stream(str.substring(1, str.length() - 1).split(",")).map(r -> {
            return Integer.parseInt(r);
        }).collect(Collectors.toList());
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static String[] stringToStrArray(String str) {
        String[] result = str.substring(1, str.length() - 1).split(",");
        return result;
    }
}
