package pkg202007;

public class L482 {

    public static void main(final String[] args) {
        System.out.println(new L482().licenseKeyFormatting("--a-a-a-a--", 2));
    }

    public String licenseKeyFormatting(final String S, final int K) {
        final char[] cs = S.toCharArray();
        int tik = 0;
        final StringBuilder builder = new StringBuilder();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '-') {
                continue;
            }
            if (tik == K) {
                builder.append('-');
                tik = 0;
            }
            builder.append(Character.toUpperCase(cs[i]));
            tik++;
        }

        return builder.reverse().toString();
    }
}
