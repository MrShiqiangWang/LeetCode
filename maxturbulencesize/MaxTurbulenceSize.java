package maxturbulencesize;

public class MaxTurbulenceSize {
	public int maxTurbulenceSize(int[] A) {
		int max = 1;
		int size = 0;

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				size++;
				continue;
			}
			if (i == 1) {
				if (A[i] != A[i - 1]) {
					size++;
					continue;
				} else {
					max = Math.max(size, max);
					size = 1;
				}
			}
			if (A[i] < A[i - 1]) {
				if (A[i - 1] < A[i - 2]) {
					// 取大值
					max = Math.max(size, max);
					size = 2;
				} else if (A[i - 1] == A[i - 2]) {
					// 取大值
					max = Math.max(size, max);
					size = 2;
				} else {
					size++;
				}
			} else if (A[i] == A[i - 1]) {
				// 取大值
				max = Math.max(size, max);
				size = 1;
			} else {
				if (A[i - 1] > A[i - 2]) {
					// 取大值
					max = Math.max(size, max);
					size = 2;
				} else if (A[i - 1] == A[i - 2]) {
					// 取大值
					max = Math.max(size, max);
					size = 1;
				} else {
					size++;
				}
			}
		}
		// 取大值
		max = Math.max(size, max);
		return max;
	}
}
