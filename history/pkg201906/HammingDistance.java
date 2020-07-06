package history.pkg201906;

public class HammingDistance {

    public int hammingDistance(final int x, final int y) {
        final int result = x ^ y;
        int count = 0;
        for (int n = result; n > 0; n /= 2) {
            if (n % 2 == 1) {
                count++;
            }
        }
        return count;

    }
}
