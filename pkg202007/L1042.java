package pkg202007;

import java.util.LinkedList;

import utils.MatrixHelper;

public class L1042 {

	public static void main(String[] args) {
		System.out.println(new L1042().gardenNoAdj(3, MatrixHelper.stringToMatrix("[1,2],[2,3],[3,1]]")));
	}

	@SuppressWarnings("unchecked")
	public int[] gardenNoAdj(int N, int[][] paths) {
		LinkedList<Integer>[] adj = (LinkedList<Integer>[]) new LinkedList[N + 1];// 邻接表数组

		// 建立邻接表
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < paths.length; i++) {
			adj[paths[i][0]].add(paths[i][1]);
			adj[paths[i][1]].add(paths[i][0]);
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = -1;
		}
		for (int i = 1; i <= N; i++) {
			boolean[] colors = new boolean[4];
			// 根据邻接矩阵，找到已经种植了花的
			LinkedList<Integer> adjs = adj[i];
			for (int j = 0; j < adjs.size(); j++) {
				if (result[adjs.get(j) - 1] != -1) {
					colors[result[adjs.get(j) - 1]-1] = true;
				}
			}
			// 找到最小的花的号码
			for (int j = 0; j < 4; j++) {
				if (colors[j] == false) {
					result[i - 1] = j + 1;
					break;
				}
			}
		}
		return result;
	}
}
