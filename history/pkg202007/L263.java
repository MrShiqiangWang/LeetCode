package history.pkg202007;

public class L263 {
	public boolean isUgly(int num) {
		while (num % 2 == 0) {
			num = num / 2;
		}
		if (num == 1) {
			return true;
		}
		while (num % 3 == 0) {
			num = num / 3;
		}
		if (num == 1) {
			return true;
		}
		while (num % 5 == 0) {
			num = num / 5;
		}
		if (num == 1)
			return true;
		return false;
	}
}
