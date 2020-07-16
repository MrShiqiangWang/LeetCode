package pkg202007;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

import utils.ArrayHelper;

public class L217 {

	public static void main(String[] args) {
		System.out.println(new L217().containsDuplicate(ArrayHelper.stringToArray("[3,3]")));
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
