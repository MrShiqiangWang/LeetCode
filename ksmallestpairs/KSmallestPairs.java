package ksmallestpairs;

import java.util.ArrayList;
import java.util.List;

public class KSmallestPairs {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		int m = 0;
		int x = 0;
		int y = 0;
		List<List<Integer>> result = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0) {
			return new ArrayList<>();
		}
		m = 1;
		List<Integer> tmp = new ArrayList<>();
		tmp.add(nums1[0]);
		tmp.add(nums2[0]);
		result.add(tmp);
		while (m < k) {
			if (x > nums1.length) {

			} else if (y >= nums2.length) {

			} else if (x + 1 >= nums1.length && y + 1 >= nums2.length) {

			} else if (y + 1 >= nums2.length) {
				x++;
				List<Integer> list = new ArrayList<>();
				list.add(nums1[x]);
				list.add(nums2[y]);
				result.add(list);
			} else if (x + 1 > nums1.length) {
				y++;
				List<Integer> list = new ArrayList<>();
				list.add(nums1[x]);
				list.add(nums2[y]);
				result.add(list);
			} else if (nums1[x + 1] + nums2[y] <= nums2[x] + nums2[y + 1]) {
				x++;
				List<Integer> list = new ArrayList<>();
				list.add(nums1[x]);
				list.add(nums2[y]);
				result.add(list);
			} else {
				y++;
				List<Integer> list = new ArrayList<>();
				list.add(nums1[x]);
				list.add(nums2[y]);
				result.add(list);
			}
			m++;
		}
		return result;
	}
}
