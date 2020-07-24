package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ArrayHelper;

public class L1207 {

	public static void main(String[] args) {
		System.out.println(new L1207().uniqueOccurrences(ArrayHelper
				.stringToArray("[26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16]")));
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list);
		int pre = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == pre) {
				return false;
			}
			pre = list.get(i);
		}
		return true;

	}
}
