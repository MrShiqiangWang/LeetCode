package pkg202007;

public class L693 {
	public boolean hasAlternatingBits(int n) {
		char[] cs = Integer.toBinaryString(n).toCharArray();
		for (int i = 0; i < cs.length - 1; i++) {
			if (cs[i] == cs[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
