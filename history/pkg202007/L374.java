package history.pkg202007;

public class L374 {

    public int guessNumber(final int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            final int mid = left + (right - left) / 2;
            if (this.guess(mid) == 0) {
                return mid;
            }
            else if (this.guess(mid) > 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    int guess(final int num) {
        return num;
    }
}
