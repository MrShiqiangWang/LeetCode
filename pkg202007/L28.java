package pkg202007;

public class L28 {

	public static void main(String[] args) {
		System.out.println(new L28().strStr("hello", "ll"));
	}

	public int strStr(String haystack, String needle) {
		int i = 0;
		int k = 0;
		char[] hs = haystack.toCharArray();
		char[] ns = needle.toCharArray();
		for (; i < hs.length; i++) {
			if (hs[i] == ns[k]) {
				k++;
				if (k == ns.length) {
					return i - k + 1;
				}
			} else {
				i = i - k;
				k = 0;
			}
		}
		return -1;
	}
}
