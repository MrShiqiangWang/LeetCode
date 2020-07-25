package pkg202007;

public class L686 {

	public int repeatedStringMatch(String A, String B) {
		int counter = B.length() / A.length();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < counter; i++) {
			builder.append(A);
		}
		if (builder.toString().contains(B)) {
			return counter;
		}
		builder.append(A);
		if (builder.toString().contains(B)) {
			return counter + 1;
		}
		return -1;
	}
}
