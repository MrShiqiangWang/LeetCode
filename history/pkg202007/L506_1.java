package history.pkg202007;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

import utils.ArrayHelper;

public class L506_1 {

    public static void main(final String[] args) {
        System.out.println(new L506_1().findRelativeRanks(ArrayHelper.stringToArray("[5,4,3,2,1]")));
    }

    public String[] findRelativeRanks(final int[] nums) {

        final TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        final String[] result = new String[nums.length];

        int counter = 1;
        for (final Entry<Integer, Integer> entry : map.entrySet()) {
            result[entry.getValue()] = this.getMinci(counter);
            counter++;
        }
        return result;
    }

    private String getMinci(final int counter) {
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
