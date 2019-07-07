package package_in_201907;

public class SurfaceArea {

	public static void main(String[] args) {
		int[][] grid = { { 1,2 },{3,4} };
		System.out.println(new SurfaceArea().surfaceArea(grid));
	}

	public int surfaceArea(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int z = grid[i][j];
				for (int k = 0; k < z; k++) {
					// ǰ��
					if (i - 1 < 0) {
						sum++;
					} else {
						if (grid[i - 1][j] > k) {
							sum++;
						}
					}
					// ����
					if (i + 1 == grid.length) {
						sum++;
					} else {
						if (grid[i + 1][j] < k) {
							sum++;
						}
					}
					// ����
					if (j - 1 < 0) {
						sum++;
					} else {
						if (grid[i][j - 1] > k) {
							sum++;
						}
					}
					// ����
					if (j + 1 == grid[0].length) {
						sum++;
					} else {
						if (grid[i][j + 1] < k) {
							sum++;
						}
					}

					// ����
					if (k == 0) {
						sum++;
					}
					// ����
					if (k == z - 1) {
						sum++;
					}
				}
			}
		}
		return sum;
	}
}
