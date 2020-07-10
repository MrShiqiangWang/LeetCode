package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L1030 {

    private static class Cell {

        private final int i;
        private final int j;
        private final int distance;

        public Cell(final int i, final int j, final int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int[][] allCellsDistOrder(final int R, final int C, final int r0, final int c0) {

        final List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                final int distance = Math.abs(i - r0) + Math.abs(j - c0);
                cells.add(new Cell(i, j, distance));
            }
        }

        Collections.sort(cells, new Comparator<Cell>() {

            @Override
            public int compare(final Cell o1, final Cell o2) {
                return o1.distance - o2.distance;
            }
        });

        final int[][] re = new int[R * C][2];

        for (int i = 0; i < cells.size(); i++) {
            re[i][0] = cells.get(i).i;
            re[i][1] = cells.get(i).j;
        }
        return re;
    }
}
