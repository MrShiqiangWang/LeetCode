package pkg202007;

import java.math.BigInteger;

public class L69 {

    public static void main(final String[] args) {
        new L69().mySqrt(2147395599);
    }

    public int mySqrt(final int x) {
        return this.mySqrt(0, x, x);
    }

    private int mySqrt(final int left, final int right, final int target) {
        if (right < left) {
            return right;
        }
        final int mid = (left + right) / 2;

        final BigInteger value = BigInteger.valueOf(mid).multiply(BigInteger.valueOf(mid));

        if (value.compareTo(BigInteger.valueOf(target)) == 0) {
            return mid;
        }
        else if (value.compareTo(BigInteger.valueOf(target)) < 0) {
            return this.mySqrt(mid + 1, right, target);
        }
        else {
            return this.mySqrt(left, mid - 1, target);
        }
    }
}
