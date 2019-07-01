package judgesquaresum;

public class JudgeSquareSum {
	public boolean judgeSquareSum(int c) {
		int count = (int) Math.sqrt(c);
		for (int i = 0; i < count; i++) {
			int a = (int) Math.sqrt(c - i * i);
			if (a * a + i * i == c) {
				return true;
			}
		}
		return false;
	}
}
