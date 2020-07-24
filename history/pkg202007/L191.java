package history.pkg202007;

public class L191 {

    public int hammingWeight(final int n) {
        final char[] cs = Integer.toUnsignedString(n, 2).toCharArray();
        int size = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') {
                size++;
            }
        }
        return size;
    }
}
