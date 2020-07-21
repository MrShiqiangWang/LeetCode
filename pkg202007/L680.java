package pkg202007;

public class L680 {

    public static void main(String[] args) {
        System.out.println(new L680().validPalindrome("acbca"));
    }

    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int left = 0;
        int right = cs.length - 1;
        while (left < right) {
            if (cs[left] == cs[right]) {
                left++;
                right--;
            }
            else {
                return validPalindrome(cs, left, right - 1) || validPalindrome(cs, left + 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(char[] cs, int left, int right) {
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
