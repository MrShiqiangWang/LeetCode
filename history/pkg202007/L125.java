package history.pkg202007;

public class L125 {

    public static void main(final String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');

        System.out.println((int) 'Z');
        System.out.println((int) '1');
        System.out.println((int) '9');

    }

    public boolean isPalindrome(final String s) {
        final char[] cs = s.toCharArray();
        int left = 0;
        int right = cs.length - 1;
        while (left <= right) {
            // ��������ĸ�����ֵ�ch
            if (!Character.isLetterOrDigit(cs[left])) {
                left++;
            }
            else if (!Character.isLetterOrDigit(cs[right])) {
                right--;
            }
            else {
                if (cs[left] == cs[right]) {
                    left++;
                    right--;
                }
                else if (Character.isDigit(cs[left]) || Character.isDigit(cs[right])) {
                    return false;
                }
                else {
                    if (cs[left] <= 122 && cs[left] >= 96) {
                        if (cs[left] - 32 != cs[right]) {
                            return false;
                        }
                        left++;
                        right--;
                    }
                    else {
                        if (cs[left] + 32 != cs[right]) {
                            return false;
                        }
                        left++;
                        right--;
                    }
                }
            }

        }
        return true;
    }
}
