package history.pkg201907;

import java.math.BigInteger;

public class QueryString {

    public static void main(final String[] args) {
        System.out.println(new QueryString().queryString("110101011011000011011111000000", 15));
    }

    public boolean queryString(final String S, final int N) {
        for (int i = 1; i <= N; i++) {
            final BigInteger bigInteger = BigInteger.valueOf(i);
            final String nString = bigInteger.toString(2);

            if (S.indexOf(nString) == -1) {
                return false;
            }

        }
        return true;
    }
}
