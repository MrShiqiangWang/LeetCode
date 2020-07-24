package pkg202007;

public class L566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums.length * nums[0].length != r * c) {
			return nums;
		}
		int rIndex = 0;
		int cIndex = 0;
		int result[][] = new int[r][c];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				result[rIndex][cIndex] = nums[i][j];
				if (cIndex == c) {
					rIndex++;
					cIndex = 0;
				} else {
					cIndex++;
				}
			}
		}
		return result;
	}
}
