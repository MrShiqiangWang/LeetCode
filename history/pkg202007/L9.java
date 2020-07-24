package history.pkg202007;

public class L9 {

    public boolean isPalindrome(final int x) {
        if (x < 0) {
            return false;
        }
        final char[] cs = Integer.toString(x).toCharArray();
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
