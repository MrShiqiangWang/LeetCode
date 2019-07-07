package package_in_201907;

public class AddDigits {
	public int addDigits(int num) {
		int sum = num;
		while (sum >= 10) {
			String numStr = String.valueOf(sum);
			// 得到每一个位的数字
			char[] chars = numStr.toCharArray();
			sum = 0;
			for (int i = 0; i < chars.length; i++) {
				sum += Integer.parseInt(chars[i] + "");
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new AddDigits().addDigits(38));
	}
}
