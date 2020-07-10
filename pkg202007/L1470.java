package pkg202007;

public class L1470 {

    public int[] shuffle(final int[] nums, final int n) {
        final int[] result = new int[2 * n];
        int i = 0, j = 0;
        final int index = 0;
        for (; i < n && j < n;) {
            if (i == j) {
                result[index] = nums[i];
                i++;
            }
            else {
                result[index] = nums[j + n];
                j++;
            }
        }
        return result;
    }
}
