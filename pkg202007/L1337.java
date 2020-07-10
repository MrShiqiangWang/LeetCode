package pkg202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import utils.ArrayHelper;
import utils.MatrixHelper;

public class L1337 {

    public static void main(String[] args) {
        System.out.println(new L1337().kWeakestRows(MatrixHelper.stringToMatrix("[[1,0],[1,0],[1,0],[1,1]]"), 4));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        // mat
        List<Integer[]> statistics = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            boolean added = false;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    Integer[] item = { j, i };
                    statistics.add(item);
                    added = true;
                    break;
                }
            }
            if (!added) {
                Integer[] item = { mat[i].length, i };
                statistics.add(item);
            }
        }
        Collections.sort(statistics, new Comparator<Integer[]>() {

            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0].compareTo(o2[0]) == 0) {
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = statistics.get(i)[1];
        }
        return res;

    }
}
