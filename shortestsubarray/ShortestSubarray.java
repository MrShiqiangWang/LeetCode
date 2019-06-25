package shortestsubarray;

public class ShortestSubarray {

	public int shortestSubarray(int[] A, int K) {
		int length = A.length;
		int sum = 0;
		int begin = 0;
		for (int i = 0; i < length; i++) {
			if (A[i] >= K) {
				return 1;
			}
			// �����ܺ�
			sum += A[i];

			if (sum < 0) {
				// ���ٴ�i+1��ʼ
				begin = i + 1;
				// ���Ӧ�ù滮Ϊ0
				sum = 0;
			}
			if (sum >= K) {
				break;
			}
		}
		sum = 0;
		int end = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (A[i] > K) {
				return 1;
			}
			sum += A[i];
			if (sum < 0) {
				end = i - 1;
				sum = 0;
			}
			if (sum >= K) {
				break;
			}
		}

		int a[] = new int[length];
		for (int i = 1; i <= end - begin+1; i++) {
			for (int j = begin; j <= end - i + 1; j++) {
				a[j] += A[j + i - 1];
				if (a[j] >= K) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int A[] = { 2,-1,2};
		System.out.println(new ShortestSubarray().shortestSubarray(A, 3));
	}
}
