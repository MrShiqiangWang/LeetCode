package pkg202007;

public class L762 {
	public int countPrimeSetBits(int L, int R) {
		int counter = 0;
		for (int i = L; i <= R; i++) {
			char[] cs = Integer.toUnsignedString(i, 2).toCharArray();
			int size = 0;
			for (int j = 0; j < cs.length; j++) {
				if (cs[j] == '1') {
					size++;
				}
			}
			if (isPrime(size)) {
				counter++;
			}
		}
		return counter;
	}

	private boolean isPrime(int num) {
		int k = (int) Math.sqrt(num);// k为num的正平方根，取整数
		for (int i = 2; i <= k; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
