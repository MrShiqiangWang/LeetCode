package pkg202007;

public class L9 {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		char[] cs = Integer.toString(x).toCharArray();
		int left = 0;
		int right = cs.length - 1;
		while (left < right) {
			if (cs[left] != cs[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
