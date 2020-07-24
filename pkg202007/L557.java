package pkg202007;

public class L557 {
	public String reverseWords(String s) {
		char[] cs = s.toCharArray();
		StringBuilder words = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == ' ') {
				words.append(builder.reverse().toString());
				words.append(" ");
				builder = new StringBuilder();
			} else {
				builder.append(cs[i]);
			}
		}
		words.append(builder.reverse().toString());
		return words.toString();
	}
}
