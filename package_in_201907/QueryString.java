package package_in_201907;

import java.math.BigInteger;

public class QueryString {

	public static void main(String[] args) {
		System.out.println(new QueryString().queryString("110101011011000011011111000000", 15));
	}

	public boolean queryString(String S, int N) {
		for (int i = 1; i <= N; i++) {
			BigInteger bigInteger = BigInteger.valueOf(i);
			String nString = bigInteger.toString(2);

			if (S.indexOf(nString) == -1) {
				return false;
			}

		}
		return true;
	}
}
