package largestvalsfromlabels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestValsFromLabels {
	class ValueAndLabel {
		int value;
		int label;

		public ValueAndLabel(int label, int value) {
			this.label = label;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int[] values = { 5, 4, 3, 2, 1 };
		int[] labels = { 1, 3, 3, 3, 2 };
		System.out.println(new LargestValsFromLabels().largestValsFromLabels(values, labels, 3, 2));
	}

	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
		List<ValueAndLabel> list = new ArrayList<>();
		for (int i = 0; i < labels.length; i++) {
			ValueAndLabel valueAndLabel = new ValueAndLabel(labels[i], values[i]);
			list.add(valueAndLabel);
		}
		Collections.sort(list, new Comparator<ValueAndLabel>() {

			@Override
			public int compare(ValueAndLabel o1, ValueAndLabel o2) {
				if (o1.value < o2.value) {
					return 1;
				} else if (o1.value == o2.value) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		// 取不同的label的最大的数据
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < list.size() && sum < num_wanted; i++) {
			if (map.containsKey(list.get(i).label)) {
				if (map.get(list.get(i).label) == use_limit) {
					continue;
				} else {
					map.put(list.get(i).label, map.get(list.get(i).label) + 1);
					result += list.get(i).value;
					sum++;
				}
			} else {
				map.put(list.get(i).label, 1);
				sum++;
				result += list.get(i).value;
			}
			// 如果sum的值
		}
		return result;

	}
}
