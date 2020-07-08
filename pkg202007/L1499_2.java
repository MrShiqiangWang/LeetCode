package pkg202007;

import java.util.Deque;
import java.util.LinkedList;

import javafx.util.Pair;
import utils.MatrixHelper;

public class L1499_2 {

    public static void main(final String[] args) {
        final int[][] points = MatrixHelper.stringToMatrix("[[1,3],[2,0],[5,10],[6,-10]]");
        System.out.println(new L1499_2().findMaxValueOfEquation(points, 1));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int findMaxValueOfEquation(final int[][] points, final int k) {

        final Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(points[0][0], points[0][1] - points[0][0]));
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < points.length; i++) {
            // 刪除队列头部不符合条件的元素
            while (!queue.isEmpty()) {
                final Pair<Integer, Integer> pair = queue.peek();
                if (points[i][0] - pair.getKey() > k) {
                    queue.poll();
                }
                else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                res = Math.max(points[i][0] + points[i][1] + queue.peekFirst().getValue(), res);
            }
            // 队列中比当前的y-x还小的数据删除掉
            while (!queue.isEmpty()) {
                final Pair<Integer, Integer> pair = queue.peekLast();
                if (pair.getValue() < points[i][1] - points[i][0]) {
                    queue.pollLast();
                }
                else {
                    break;
                }
            }

            queue.add(new Pair(points[i][0], points[i][1] - points[i][0]));
        }
        return res;
    }
}
