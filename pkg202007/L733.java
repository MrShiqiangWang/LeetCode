package pkg202007;

import utils.MatrixHelper;

public class L733 {

    public static void main(final String[] args) {
        System.out.println(new L733().floodFill(MatrixHelper.stringToMatrix("[[0,0,0],[0,1,1]]"), 1, 1, 1));
    }

    public int[][] floodFill(final int[][] image, final int sr, final int sc, final int newColor) {
        final int oldColor = image[sr][sc];
        final boolean[][] biaoji = new boolean[image.length][image[0].length];
        this.floodFill(image, sr, sc, newColor, oldColor, biaoji);
        return image;

    }

    private void floodFill(final int[][] image, final int sr, final int sc, final int newColor, final int oldColor, final boolean[][] biaoji) {
        if (sr < 0 || sr >= image.length) {
            return;
        }
        if (sc < 0 || sc >= image[sr].length) {
            return;
        }
        if (image[sr][sc] == oldColor && biaoji[sr][sc] == false) {
            image[sr][sc] = newColor;
            biaoji[sr][sc] = true;
            // 向上
            this.floodFill(image, sr, sc - 1, newColor, oldColor, biaoji);
            // 向下
            this.floodFill(image, sr, sc + 1, newColor, oldColor, biaoji);
            // 向左
            this.floodFill(image, sr - 1, sc, newColor, oldColor, biaoji);
            // 向右
            this.floodFill(image, sr + 1, sc, newColor, oldColor, biaoji);
        }
    }
}
