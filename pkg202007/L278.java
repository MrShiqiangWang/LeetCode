package pkg202007;

public class L278 {

    public static void main(final String[] args) {
        new L278().firstBadVersion(2126753390);
    }

    public int firstBadVersion(final int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            final int mid = left + (right - left) / 2;
            if (this.isBadVersion(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (this.isBadVersion(left)) {
            return left;
        }
        return left + 1;
    }

    boolean isBadVersion(final int version) {
        return version == 1702766719;
    }
}
