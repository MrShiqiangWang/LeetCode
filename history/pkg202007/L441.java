package history.pkg202007;

public class L441 {

    public static void main(final String[] args) {
        System.out.println(new L441().arrangeCoins(1804289383));
    }

    public int arrangeCoins(final int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long left = 2;
        long right = n;

        while (left <= right) {
            final long mid = left + (right - left) / 2;
            final long number = mid * (1 + mid) / 2;
            if (number == n) {
                return (int) mid;
            }
            else if (number < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
