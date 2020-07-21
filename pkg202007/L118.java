package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L118 {

    public List<List<Integer>> generate(final int numRows) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> preItem = new ArrayList<>();
        preItem.add(1);
        result.add(preItem);
        List<Integer> currentItems = null;
        for (int i = 2; i <= numRows; i++) {
            currentItems = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    currentItems.add(1);
                }
                else if (j == i - 1) {
                    currentItems.add(1);
                    result.add(currentItems);
                    preItem = currentItems;
                }
                else {
                    currentItems.add(preItem.get(j - 1) + preItem.get(j));
                }
            }
        }
        return result;
    }
}
