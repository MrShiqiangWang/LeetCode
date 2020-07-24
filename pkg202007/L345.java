package pkg202007;

public class L345 {

    public String reverseVowels(final String s) {
        final char[] cs = s.toCharArray();
        int left = 0;
        int right = cs.length - 1;
        char tmp;
        while (left < right) {
            if (this.isVowel(cs[left]) && this.isVowel(cs[right])) {
                tmp = cs[left];
                cs[left] = cs[right];
                cs[right] = tmp;
                right--;
                left++;
            }
            else if (this.isVowel(cs[left])) {
                right--;
            }
            else if (this.isVowel(cs[right])) {
                left++;
            }
            else {
                right--;
                left++;
            }
        }
        return new String(cs);
    }

    private boolean isVowel(final char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
