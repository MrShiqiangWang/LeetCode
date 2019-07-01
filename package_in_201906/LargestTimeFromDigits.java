package package_in_201906;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeFromDigits {

	public String largestTimeFromDigits(int[] A) {
		List<Integer[]> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j != i) {
					for (int k = 0; k < 4; k++) {
						if (k != i && k != j) {
							for (int l = 0; l < 4; l++) {
								if (l != i && l != j && l != k) {
									// ÕâÊÇÓÐi£¬j£¬k£¬l
									if (check(i, j, k, l, A)) {
										Integer[] array = { A[i], A[j], A[k], A[l] };
										result.add(array);
									}
								}
							}
						}
					}
				}
			}
		}
		if (result.isEmpty()) {
			return "";
		}
		Integer[] max = result.get(0);

		for (int i = 0; i < result.size(); i++) {
			max = max(max, result.get(i));
		}

		return String.format("%s%s:%s%s", max[0], max[1], max[2], max[3]);
	}

	private Integer[] max(Integer[] max, Integer[] integers) {
		for (int i = 0; i < 4; i++) {
			if (max[i] > integers[i]) {
				return max;
			} else if (max[i] == integers[i]) {
				continue;
			} else {
				return integers;
			}
		}
		return max;
	}

	private boolean check(int i, int j, int k, int l, int[] a) {
		if (a[i] == 0) {
			if (a[k] < 6) {
				return true;
			} else {
				return false;
			}
		}
		if (a[i] == 1) {
			if (a[k] < 6) {
				return true;
			} else {
				return false;
			}
		}
		if (a[i] == 2) {
			if (a[j] <= 3) {
				if (a[k] < 6) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}

}
