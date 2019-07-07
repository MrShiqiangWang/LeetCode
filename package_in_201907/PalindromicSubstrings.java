package package_in_201907;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		char[] charArray = s.toCharArray();

		int sum = 0;
		for (int i = 0; i < charArray.length; i++) {
			sum += count(i, i + 1, charArray);
			sum += count(i, i, charArray);
		}
		return sum;
	}

	private int count(int i, int j, char[] charArray) {
		int start = i;
		int end = j;
		int num = 0;
		while (start >= 0 && end < charArray.length && charArray[i] == charArray[j]) {
			num++;
			start--;
			end++;
		}
		return num;
	}
}
