package history.pkg202007;

public class L367_1 {

    public static void main(final String[] args) {
        System.out.println(new L367_1().isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(final int num) {
        if (num < 2) {
            return true;
        }
        long left = 2;
        long right = num / 2;

        long mid;
        long guessSquare;

        while (left <= right) {
            mid = left + (right - left) / 2;
            guessSquare = mid * mid;
            if (guessSquare == num) {
                return true;
            }
            else if (guessSquare < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
