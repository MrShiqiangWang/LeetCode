package package_in_201906;

public class FlipAndInvertImage {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			reverse(A[i]);
		}
		return A;
	}

	private void reverse(int[] is) {
		for (int i = 0; i < is.length / 2; i++) {
			int tmp = is[i];
			is[i] = is[is.length - 1 - i];
			is[i] = tmp;
		}
		for (int i = 0; i < is.length; i++) {
			is[i] = reverseDigit(is[i]);
		}
	}

	private int reverseDigit(int tmp) {
		if (tmp == 0) {
			return 1;
		}
		return 0;
	}
}
