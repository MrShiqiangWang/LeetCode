package pkg202007;

public class L908 {
	public int smallestRangeI(int[] A, int K) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			min = Math.min(A[i], min);
			max = Math.max(A[i], max);
		}
		if(max-min+1==K) {
			return 0;
		}
		return K;
	}
}
