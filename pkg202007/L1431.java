package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L1431 {

    public List<Boolean> kidsWithCandies(final int[] candies, final int extraCandies) {
        final List<Boolean> result = new ArrayList<Boolean>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            }
            else {
                result.add(false);
            }
        }
        return result;
    }
}
