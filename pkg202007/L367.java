package pkg202007;

public class L367 {

    public static void main(final String[] args) {
        System.out.println(new L367().isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(final int num) {
        int left = 0;

        int right = num;

        final long target = num;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final long value = mid * mid;
            if (value == target) {
                return true;
            }
            else if (value < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
