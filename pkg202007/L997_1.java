package pkg202007;

import java.util.Arrays;

public class L997_1 {
	public int findJudge(int N, int[][] trust) {
		int[][] graph = new int[N + 1][2];
		Arrays.stream(trust).forEach(array -> {
			// 出度+1
			graph[array[0]][0]++;
			// 入度+1
			graph[array[1]][1]++;
		});
		for (int i = 1; i < graph.length; i++) {
			if (graph[i][0] == 0 && graph[i][1] == N - 1) {
				return i;
			}
		}
		return -1;
	}
}
