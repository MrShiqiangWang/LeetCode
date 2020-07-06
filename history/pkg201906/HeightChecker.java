package history.pkg201906;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(final int[] heights) {
        int sum = 0;
        final int[] result = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(result);
        for (int i = 0; i < heights.length; i++) {
            if (result[i] != heights[i]) {
                sum++;
            }
        }
        return sum;
    }
}
