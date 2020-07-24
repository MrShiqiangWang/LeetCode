package history.pkg202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.ArrayHelper;

public class L349 {

    public static void main(final String[] args) {

        System.out.println(new L349().intersection(ArrayHelper.stringToArray("[4,9,5]"), ArrayHelper.stringToArray("[9,4,9,8,4]")));
    }

    public int[] intersection(final int[] nums1, final int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        final List<Integer> result = new ArrayList<Integer>();
        for (; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        final int[] re = new int[result.size()];
        for (int s = 0; s < result.size(); s++) {
            re[s] = result.get(s);
        }
        return re;
    }
}
