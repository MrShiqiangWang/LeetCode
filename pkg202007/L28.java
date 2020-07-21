package pkg202007;

public class L28 {

    public static void main(final String[] args) {
        System.out.println(new L28().strStr("hello", "ll"));
    }

    public int strStr(final String haystack, final String needle) {
        int i = 0;
        int k = 0;
        final char[] hs = haystack.toCharArray();
        final char[] ns = needle.toCharArray();
        for (; i < hs.length; i++) {
            if (hs[i] == ns[k]) {
                k++;
                if (k == ns.length) {
                    return i - k + 1;
                }
            }
            else {
                i = i - k;
                k = 0;
            }
        }
        return -1;
    }
}
