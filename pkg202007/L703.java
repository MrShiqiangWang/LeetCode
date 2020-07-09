package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class L703 {

    class KthLargest {

        List<Integer> nums = new ArrayList<Integer>();

        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                this.nums.add(nums[i]);
            }
        }

        public int add(int val) {
            this.nums.add(val);
            Collections.sort(this.nums, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }

            });
            return this.nums.get(this.k - 1);
        }
    }
}
