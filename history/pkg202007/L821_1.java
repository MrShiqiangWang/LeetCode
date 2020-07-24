package history.pkg202007;

public class L821_1 {

	public static void main(String[] args) {
		System.out.println(new L821_1().shortestToChar("aaba", 'b'));
	}

	public int[] shortestToChar(String S, char C) {
		char[] cs = S.toCharArray();
		int[] re = new int[cs.length];
		int pre = -1;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == C) {
				pre = i;
			}
			if (pre == -1) {
				re[i] = -1;
				continue;
			}
			re[i] = i - pre;
		}
		pre = -1;
		for (int i = cs.length - 1; i >= 0; i--) {
			if (cs[i] == C) {
				pre = i;
			}
			if (pre == -1) {
				continue;
			}
			if (re[i] == -1) {
				re[i] = pre - i;
				continue;
			}
			re[i] = Math.min(re[i], pre - i);
		}
		return re;
	}
}
