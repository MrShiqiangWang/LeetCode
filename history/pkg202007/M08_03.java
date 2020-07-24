package history.pkg202007;

public class M08_03 {

    public int findMagicIndex(final int[] nums) {
        int index;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                index = i;
                return index;
            }
        }
        return -1;
    }
}
