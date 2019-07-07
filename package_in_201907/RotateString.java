package package_in_201907;

public class RotateString {

	public static void main(String[] args) {
		System.out.println(new RotateString().rotateString("abcde", "abced"));
	}

	public boolean rotateString(String A, String B) {
		char[] achars = A.toCharArray();
		char[] bchars = B.toCharArray();

		if (achars.length != bchars.length) {
			return false;
		}
		int i = 0;
		int j = 0;

		while (i < achars.length && j < bchars.length) {
			j = 0;
			// 找到i中第一个和achars相同的字符
			while (i < achars.length && achars[i] != bchars[j]) {
				i++;
			}
			if (i == achars.length && achars[i-1] != bchars[j]) {
				return false;
			}

			int tmpI = i;
			while (j < bchars.length && achars[tmpI] == bchars[j]) {
				tmpI++;
				if (tmpI == achars.length) {
					tmpI = 0;
				}
				j++;
			}

			if (j == bchars.length) {
				return true;
			} else {
				i++;
			}
		}
		return false;
	}
}
