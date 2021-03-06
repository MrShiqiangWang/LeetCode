package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L1237 {

    class CustomFunction {

        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(final int x, final int y) {
            return y;
        }
    };

    public List<List<Integer>> findSolution(final CustomFunction customfunction, final int z) {

        int i = 1;
        int j = 1000;
        final List<List<Integer>> result = new ArrayList<>();

        int ans;
        while (i <= 1000 && j >= 1) {
            ans = customfunction.f(i, j);
            if (ans == z) {
                final List<Integer> item = new ArrayList<>();
                item.add(i);
                item.add(j);
                result.add(item);
                i++;
                j--;
            }
            else if (ans > z) {
                j--;
            }
            else {
                i++;
            }
        }

        return result;

    }
}
