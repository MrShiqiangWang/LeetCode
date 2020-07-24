package history.pkg202007;

public class L38 {

    public String countAndSay(final int n) {
        if (n == 1) {
            return "1";
        }

        final char[] cs = this.countAndSay(n - 1).toCharArray();
        final StringBuilder builder = new StringBuilder();
        char pre = cs[0];
        int counter = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != pre) {
                builder.append(counter);
                builder.append(pre);
                pre = cs[i];
                counter = 1;
            }
            else {
                counter++;
            }
        }
        builder.append(counter);
        builder.append(pre);

        return builder.toString();
    }
}
