package pkg202007;

public class L661 {
	public int[][] imageSmoother(int[][] M) {
		int re[][] = new int[M.length][M[0].length];
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				int sum = 0;
				int counter = 0;
				if (i - 1 >= 0) {
					if (j - 1 >= 0) {
						sum += M[i - 1][j - 1];
						counter++;
					}
					sum += M[i - 1][j];
					counter++;
					if (j + 1 < M[0].length) {
						sum += M[i - 1][j + 1];
						counter++;
					}
				}
				if (j - 1 >= 0) {
					sum += M[i][j - 1];
					counter++;
				}
				sum += M[i][j];
				counter++;
				if (j + 1 < M[0].length) {
					sum += M[i][j + 1];
					counter++;
				}
				if (i + 1 < M.length) {
					if (j - 1 >= 0) {
						sum += M[i + 1][j - 1];
						counter++;
					}
					sum += M[i + 1][j];
					counter++;
					if (j + 1 < M[0].length) {
						sum += M[i + 1][j + 1];
						counter++;
					}
				}
				re[i][j] = sum / counter;
			}
		}
		return re;

	}
}
