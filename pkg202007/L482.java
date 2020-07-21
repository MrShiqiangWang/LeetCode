package pkg202007;

public class L482 {

    public static void main(String[] args) {
        System.out.println(new L482().licenseKeyFormatting("--a-a-a-a--", 2));
    }

    public String licenseKeyFormatting(String S, int K) {
        char[] cs = S.toCharArray();
        int tik = 0;
        StringBuilder builder = new StringBuilder();
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
