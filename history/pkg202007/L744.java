package history.pkg202007;

public class L744 {

    public char nextGreatestLetter(final char[] letters, final char target) {

        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return letters[left];
    }
}
