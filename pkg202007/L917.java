package pkg202007;

public class L917 {
	public static void main(String[] args) {
		System.out.println(new L917().reverseOnlyLetters("ab-cd"));
	}

	public String reverseOnlyLetters(String S) {
		char[] cs = S.toCharArray();
		int left = 0;
		int right = cs.length - 1;
		char tmp;
		while (left < right) {
			if (Character.isLetter(cs[left]) && Character.isLetter(cs[right])) {
				tmp = cs[left];
				cs[left] = cs[right];
				cs[right] = tmp;
				left++;
				right--;
			} else if (Character.isLetter(cs[left])) {
				right--;
			} else if (Character.isLetter(cs[right])) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		return new String(cs);
	}
}
