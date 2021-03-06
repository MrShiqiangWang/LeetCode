package history.pkg202007;

public class L168 {

    public static void main(final String[] args) {
        System.out.println(new L168().convertToTitle(701));
    }

    public String convertToTitle(int n) {
        final StringBuilder builder = new StringBuilder();
        while (n != 0) {
            builder.append((char) ((n - 1) % 26 + 65));
            n = (n - 1) / 26;
        }
        return builder.reverse().toString();
    }
}
