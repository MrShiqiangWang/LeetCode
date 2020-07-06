package history.pkg201906;

public class NumArray {

    private final int nums[];

    public NumArray(final int[] nums) {
        this.nums = nums;
    }

    public int sumRange(final int i, final int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum = this.nums[k] + sum;
        }
        return sum;
    }

    public void update(final int i, final int val) {
        this.nums[i] = val;
    }
}
