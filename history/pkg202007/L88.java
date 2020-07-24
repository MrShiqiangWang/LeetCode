package history.pkg202007;

import java.util.Arrays;

public class L88 {

    public void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        final int[] is = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0;
        for (int k = 0; k < nums1.length; k++) {
            if (i < m && j < n) {
                if (is[i] <= nums2[j]) {
                    nums1[k] = is[i];
                    i++;
                }
                else {
                    nums1[k] = nums2[j];
                    j++;
                }
            }
            else if (i < m) {
                nums1[k] = is[i];
                i++;
            }
            else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}
