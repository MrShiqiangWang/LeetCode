package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L728 {

    public static void main(final String[] args) {
        System.out.println(new L728().selfDividingNumbers(1, 22));
    }

    public List<Integer> selfDividingNumbers(final int left, final int right) {
        final List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (this.isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(final int n) {
        int s = n;
        int d;
        while (s != 0) {
            d = s % 10;
            if (d == 0) {
                return false;
            }
            s = s / 10;
            if (n % d != 0) {
                return false;
            }
        }
        return true;
    }
}
