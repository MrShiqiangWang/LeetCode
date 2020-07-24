package history.pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class L1122 {

    public int[] relativeSortArray(final int[] arr1, final int[] arr2) {
        final Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }
        final List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) {
                data.add(arr1[i]);
            }
            else {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }
        final int[] result = new int[arr1.length];
        int index = 0;
        for (final Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[index] = entry.getKey();
                index++;
            }
        }
        Collections.sort(data);
        for (int i = 0; i < data.size(); i++) {
            result[index] = data.get(i);
            index++;
        }
        return result;
    }
}
