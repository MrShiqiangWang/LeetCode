package history.pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.MatrixHelper;

public class L1337 {

    public static void main(final String[] args) {
        System.out.println(new L1337().kWeakestRows(MatrixHelper.stringToMatrix("[[1,0],[1,0],[1,0],[1,1]]"), 4));
    }

    public int[] kWeakestRows(final int[][] mat, final int k) {
        // mat
        final List<Integer[]> statistics = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            boolean added = false;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    final Integer[] item = { j, i };
                    statistics.add(item);
                    added = true;
                    break;
                }
            }
            if (!added) {
                final Integer[] item = { mat[i].length, i };
                statistics.add(item);
            }
        }
        Collections.sort(statistics, new Comparator<Integer[]>() {

            @Override
            public int compare(final Integer[] o1, final Integer[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        final int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = statistics.get(i)[1];
        }
        return res;

    }
}
