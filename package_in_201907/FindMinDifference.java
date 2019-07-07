package package_in_201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.org.apache.regexp.internal.REUtil;

public class FindMinDifference {
	public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				char[] co1 = o1.toCharArray();
				char[] co2 = o2.toCharArray();
				if (co1[0] < co2[0]) {
					return -1;
				} else if (co1[0] > co2[0]) {
					return 1;
				} else {
					if (co1[1] < co2[1]) {
						return -1;
					} else if (co1[1] > co2[1]) {
						return 1;
					} else {
						if (co1[3] < co2[3]) {
							return -1;
						} else if (co1[3] > co2[3]) {
							return 1;
						} else {
							if (co1[4] < co2[4]) {
								return -1;
							} else if (co1[4] > co2[4]) {
								return 1;
							} else {
								return 0;
							}
						}
					}
				}
			}
		});

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < timePoints.size() - 1; i++) {

			int dis = calcMyDis(timePoints.get(i), timePoints.get(i + 1));

			list.add(dis);
		}

		String o1 = timePoints.get(0);
		String o2 = timePoints.get(timePoints.size() - 1);

		int hour = Integer.valueOf(o1.substring(0, 2));
		int minutes = Integer.valueOf(o1.substring(3, 5));

		int bhour = Integer.valueOf(o2.substring(0, 2));
		int bminutes = Integer.valueOf(o2.substring(3, 5));

		int dis = hour * 60 + minutes + 60 * 24 - (bhour * 60 + bminutes);

		list.add(dis);

		Collections.sort(list);

		return list.get(0);
	}

	public int calcMyDis(String a, String b) {
		int hour = Integer.valueOf(a.substring(0, 2));
		int minutes = Integer.valueOf(a.substring(3, 5));

		int bhour = Integer.valueOf(b.substring(0, 2));
		int bminutes = Integer.valueOf(b.substring(3, 5));

		int dis = bhour * 60 + bminutes - (hour * 60 + minutes);
		return dis;

	}
}
