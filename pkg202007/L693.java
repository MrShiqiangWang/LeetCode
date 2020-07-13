package pkg202007;

public class L693 {

    public boolean hasAlternatingBits(final int n) {
        final char[] cs = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == cs[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
