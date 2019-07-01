package package_in_201906;

public class Multiply {
	public static void main(String[] args) {
		System.out.println(new Multiply().multiply("0", "0"));
	}

	public String multiply(String num1, String num2) {
		char[] nums1 = num1.toCharArray();
		char[] nums2 = num2.toCharArray();
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 == 0 || n2 == 0) {
			return "";
		}
		int[] result = new int[n1 + n2];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				int x = ((int) nums1[n1 - i - 1]) - 48;
				int y = ((int) nums2[n2 - j - 1]) - 48;
				int z = x * y;
				int mode = z % 10;
				int div = z / 10;
				result[i + j + 1] = result[i + j + 1] + div;
				result[i + j] = result[i + j] + mode;
			}
		}

		for (int i = 0; i < n1 + n2 - 1; i++) {
			result[i + 1] += (result[i] / 10);
			result[i] = result[i] % 10;
		}

		StringBuffer buffer = new StringBuffer();
		boolean zerodel = false;
		for (int i = result.length - 1; i >= 0; i--) {
			if (!zerodel) {
				if (result[i] != 0) {
					zerodel = true;
					buffer.append(result[i] + "");
				}
			} else {
				buffer.append(result[i]);
			}
		}
		if (buffer.toString().equals("")) {
			return "0";
		}
		return buffer.toString();
	}
}
