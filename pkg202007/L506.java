package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class L506 {

    public String[] findRelativeRanks(int[] nums) {
        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair<Integer, Integer>(nums[i], i));
        }
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        String[] result = new String[nums.length];
        int counter = 1;
        int pre = list.get(list.size() - 1).getValue();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getKey() == pre) {
                result[list.get(i).getValue()] = getMinci(counter);
            }
            else {
                result[list.get(i).getValue()] = getMinci(counter);
                pre = list.get(i).getKey();
                counter++;
            }
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
            return counter + "";
        }
    }
}
