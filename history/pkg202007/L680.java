package history.pkg202007;

public class L680 {

    public static void main(final String[] args) {
        System.out.println(new L680().validPalindrome("acbca"));
    }

    public boolean validPalindrome(final String s) {
        final char[] cs = s.toCharArray();
        int left = 0;
        int right = cs.length - 1;
        while (left < right) {
            if (cs[left] == cs[right]) {
                left++;
                right--;
            }
            else {
                return this.validPalindrome(cs, left, right - 1) || this.validPalindrome(cs, left + 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(final char[] cs, int left, int right) {
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
