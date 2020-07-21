package pkg202007;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map.Entry;

import utils.ArrayHelper;

public class L506_1 {

    public static void main(String[] args) {
        System.out.println(new L506_1().findRelativeRanks(ArrayHelper.stringToArray("[5,4,3,2,1]")));
    }

    public String[] findRelativeRanks(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] result = new String[nums.length];

        int counter = 1;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            result[entry.getValue()] = getMinci(counter);
            counter++;
        }
        return result;
    }

    private String getMinci(int counter) {
        if (counter == 1) {
            return "Gold Medal";
        }
        else if (counter == 2) {
            return "Silver Medal";
        }
        else if (counter == 3) {
            return "Bronze Medal";
        }
        else {
            return String.valueOf(counter);
        }
    }
}
