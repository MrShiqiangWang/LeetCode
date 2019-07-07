package package_in_201907;

public class ValidSquare {

	public static void main(String[] args) {
		int[] p1 = { 0, 0 };
		int[] p2 = { 0, 0 };
		int[] p3 = { 0, 0};
		int[] p4 = { 0, 0 };

		System.out.println(new ValidSquare().validSquare(p1, p2, p3, p4));
	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// 假设 前两个点是边
		// p1 p2,p3 为直角边
		boolean result = false;
		result |= testSqure(p1, p2, p3, p4);
		result |= testSqure(p1, p2, p4, p3);
		result |= testSqure(p1, p3, p2, p4);
		result |= testSqure(p1, p3, p4, p2);
		return result;

	}

	private boolean testSqure(int[] p1, int[] p2, int[] p3, int[] p4) {
		int xd = p2[0] - p1[0];
		int yd = p2[1] - p1[1];

		// p3和p1的向量
		int xd1 = p3[0] - p1[0];
		int yd1 = p3[1] - p1[1];

		if (xd * xd1 + yd * yd1 == 0) {
			// 需要计算边的长度是否相等
			int xdis = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
			int ydis = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
			if(xdis==0||ydis==0) {
				return false;
			}
			if (xdis == ydis) {
				if (p4[0] + p1[0] == p3[0] + p2[0] && p4[1] + p1[1] == p3[1] + p2[1]) {
					return true;
				}
			}
		}
		return false;
	}
}
