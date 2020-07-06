package history.pkg201907;

public class GetMaxRepetitions {

    public static void main(final String[] args) {
        System.out.println(new GetMaxRepetitions().getMaxRepetitions("acb", 4, "ab", 2));
    }

    public int getMaxRepetitions(final String s1, final int n1, final String s2, final int n2) {
        // 构建s1
        // 构建s2
        // 求s1*n1中有多少个s2*n2的子序列

        final char[] s1char = s1.toCharArray();
        final char[] s2char = s2.toCharArray();

        final int S1Length = s1char.length * n1;

        int s1index = 0;
        int s2index = 0;
        int s2count = 0;
        for (int i = 0; i < S1Length; i++) {
            if (s1index == s1char.length) {
                s1index = 0;
            }
            if (s2index == s2char.length) {
                s2index = 0;
                s2count++;
            }
            // 如果字符数字得到增加那么s2index++
            if (s1char[s1index] == s2char[s2index]) {
                s2index++;
            }
            s1index++;
        }

        if (s2index == s2char.length) {
            s2index = 0;
            s2count++;
        }

        return s2count / n2;
    }
}
