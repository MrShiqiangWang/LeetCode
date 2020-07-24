package history.pkg202007;

public class L189 {

    public void rotate(final int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        final int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
