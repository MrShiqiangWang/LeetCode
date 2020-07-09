package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class L1030 {

    private static class Cell {

        private int i;
        private int j;
        private int distance;

        public Cell(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int distance = Math.abs(i - r0) + Math.abs(j - c0);
                cells.add(new Cell(i, j, distance));
            }
        }

        Collections.sort(cells, new Comparator<Cell>() {

            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.distance - o2.distance;
            }
        });

        int[][] re = new int[R * C][2];

        for (int i = 0; i < cells.size(); i++) {
            re[i][0] = cells.get(i).i;
            re[i][1] = cells.get(i).j;
        }
        return re;
    }
}
