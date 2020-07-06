package history.pkg201906;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class OuterTrees {

    public int[][] outerTrees(final int[][] points) {
        // n���������
        final int n = points.length;

        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(final int[] o1, final int[] o2) {
                if ((o1[0] < o2[0]) || (o1[0] == o2[0] && o1[1] < o2[1])) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });

        final int[][] res = new int[2 * n][2];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = -1;
            res[i][1] = -1;
        }
        int k = 0;

        for (int i = 0; i < n; i++) {
            while (k > 1 && this.getExternalProd(res[k - 2], res[k - 1], points[i]) < 0) {
                k--;
            }
            if (points[i][0] == 0 && points[i][1] == 0) {
            }
            res[k++] = points[i];
        }

        for (int i = n - 2, t = k; i >= 0; i--) {
            while (k > t && this.getExternalProd(res[k - 2], res[k - 1], points[i]) < 0) {
                k--;
            }
            if (points[i][0] == 0 && points[i][1] == 0) {
            }
            res[k++] = points[i];
        }

        final Set<Point> set = new HashSet<>();
        for (int i = 0; i < res.length; i++) {
            final Point p = new Point(res[i][0], res[i][1]);
            if (p.x != -1 && p.y != -1) {
                set.add(p);
            }
        }

        final int[][] result = new int[set.size()][2];

        int i = 0;
        for (final Point p : set) {
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }

    private int getExternalProd(final int[] x, final int[] y, final int[] z) {
        final int[] edge1 = { y[0] - x[0], y[1] - x[1] };
        final int[] edge2 = { z[0] - y[0], z[1] - y[1] };
        return edge1[0] * edge2[1] - edge1[1] * edge2[0];
    }
}

class Point {

    int x;
    int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.x;
        result = prime * result + this.y;
        return result;
    }

}
