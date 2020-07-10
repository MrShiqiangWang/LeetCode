package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L703 {

    class KthLargest {

        List<Integer> nums = new ArrayList<Integer>();

        int k;

        public KthLargest(final int k, final int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                this.nums.add(nums[i]);
            }
        }

        public int add(final int val) {
            this.nums.add(val);
            Collections.sort(this.nums, new Comparator<Integer>() {

                @Override
                public int compare(final Integer o1, final Integer o2) {
                    return o2.compareTo(o1);
                }

            });
            return this.nums.get(this.k - 1);
        }
    }
}
