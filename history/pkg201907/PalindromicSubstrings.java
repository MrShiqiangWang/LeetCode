package history.pkg201907;

public class PalindromicSubstrings {

    public int countSubstrings(final String s) {
        final char[] charArray = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            sum += this.count(i, i + 1, charArray);
            sum += this.count(i, i, charArray);
        }
        return sum;
    }

    private int count(final int i, final int j, final char[] charArray) {
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
