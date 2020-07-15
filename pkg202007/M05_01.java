package pkg202007;

public class M05_01 {
	public int insertBits(int N, int M, int i, int j) {
		char[] ns = Integer.toBinaryString(N).toCharArray();
		char[] ms = Integer.toBinaryString(M).toCharArray();

		int size = ns.length > j ? ns.length : (i == 0 ? j + 1 : j);
		char[] result = new char[size];
		for (int k = 0; k < size; k++) {
			if (k - (size - j)+1 >= 0 && k - (size - j)+1 < ms.length) {
				result[k] = ms[k - (size - j)+1];
			} else {
				result[k] = ns[k - (size - ns.length)];
			}
		}
		return Integer.parseUnsignedInt(new String(result), 2);
	}

	public static void main(String[] args) {
		System.out.println(new M05_01().insertBits(1024, 19, 2, 6));
	}
}
