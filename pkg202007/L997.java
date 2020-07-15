package pkg202007;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L997 {
	public int findJudge(int N, int[][] trust) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < trust.length; i++) {
			Set<Integer> set = map.getOrDefault(trust[i][1], new HashSet<>());
			set.add(trust[i][0]);
			map.put(trust[i][1], set);
		}
		int judge = -1;
		int i = 0;
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == N - 1) {
				judge = entry.getKey();
				i++;
			}
			if (entry.getValue().contains(judge)) {
				judge = -1;
				i = 0;
			}
		}
		if (i > 1) {
			return -1;
		}
		for (int j = 0; j < trust.length; j++) {
			if (trust[j][0] == judge) {
				return -1;
			}
		}
		return judge;
	}
}
