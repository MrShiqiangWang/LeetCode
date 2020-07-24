package history.pkg202007;

public class L551 {
	public boolean checkRecord(String s) {
		char[] cs = s.toCharArray();
		int absent = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == 'A') {
				absent++;
				if (absent == 2) {
					return false;
				}
			}
			if (cs[i] == 'L') {
				if (i - 2 >= 0 && cs[i - 1] == 'L' && cs[i - 2] == 'L') {
					return false;
				}
			}
		}
		return true;
	}
}
