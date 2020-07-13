package pkg202007;

public class M17_04 {

    public int missingNumber(final int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ i;
        }
        result ^= nums.length;
        return result;

    }
}
