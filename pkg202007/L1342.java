package pkg202007;

public class L1342 {
	public int numberOfSteps(int num) {
		int size = 0;
		while (num > 0) {
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = num - 1;
			}
			size++;
		}
		return size;
	}
}
