package pkg202007;

public class L342 {
	public boolean isPowerOfFour(int num) {
		while (num > 0) {
			if (num == 1) {
				return true;
			} else if (num % 4 != 0) {
				return false;
			} else {
				return isPowerOfFour(num / 2);
			}
		}
		return false;
	}
}
