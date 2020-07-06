package utils;

import java.util.ArrayList;
import java.util.List;

public class MatrixHelper {

    public static void main(String[] args) {
        int[][] matrix = MatrixHelper.stringToMatrix("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        System.out.println(matrix);
    }

    /**
     * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,
     * 30]]
     * 
     * @param matrix
     * @return
     */
    public static int[][] stringToMatrix(String str) {
        char[] chars = str.toCharArray();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> line = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                if (i + 1 < chars.length && chars[i + 1] == '[') {
                    continue;
                }
                else {
                    line = new ArrayList<>();
                }
            }
            else if (chars[i] == ']') {
                if (i + 1 < chars.length && chars[i + 1] == ']') {
                    // 添加到line
                    line.add(Integer.parseInt(builder.toString()));
                    // 重置string builder
                    builder = new StringBuilder();
                    result.add(line);
                }
                continue;
            }
            else if (chars[i] == ',') {
                if (chars[i - 1] == ']' && chars[i + 1] == '[') {
                    // 添加到line
                    line.add(Integer.parseInt(builder.toString()));
                    // 重置string builder
                    builder = new StringBuilder();
                    result.add(line);
                }
                else {
                    // 添加到line
                    line.add(Integer.parseInt(builder.toString()));
                    // 重置string builder
                    builder = new StringBuilder();
                }
            }
            else {
                builder.append(chars[i]);
            }
        }
        int M = result.size();
        int N = result.get(0).size();
        int re[][] = new int[M][N];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                re[i][j] = result.get(i).get(j);
            }
        }
        return re;
    }
}
