package pkg202007;

import java.util.HashMap;
import java.util.Map;

import utils.ArrayHelper;
import utils.MatrixHelper;

public class L874 {

    public static void main(final String[] args) {
        System.out.println(new L874().robotSim(ArrayHelper.stringToArray("[4,-1,4,-2,4]"), MatrixHelper.stringToMatrix("[[2,4]]")));
    }

    public int robotSim(final int[] commands, final int[][] obstacles) {
        int di = 0;
        int dj = 1;
        int max = 0;
        final Map<String, Boolean> obstaclesMap = new HashMap<String, Boolean>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesMap.put(obstacles[i][0] + "-" + obstacles[i][1], true);
        }

        int x = 0, y = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                if (di != 0) {
                    if (di == 1) {
                        di = 0;
                        dj = 1;
                    }
                    else {
                        di = 0;
                        dj = -1;
                    }
                }
                else {
                    if (dj == 1) {
                        dj = 0;
                        di = -1;
                    }
                    else {
                        dj = 0;
                        di = 1;
                    }
                }
            }
            else if (commands[i] == -1) {
                if (di != 0) {
                    if (di == 1) {
                        di = 0;
                        dj = -1;
                    }
                    else {
                        di = 0;
                        dj = 1;
                    }
                }
                else {
                    if (dj == 1) {
                        dj = 0;
                        di = 1;
                    }
                    else {
                        dj = 0;
                        di = -1;
                    }
                }
            }
            else {
                for (int j = 0; j < commands[i]; j++) {
                    final int tryx = x + di;
                    final int tryy = y + dj;
                    if (obstaclesMap.containsKey(tryx + "-" + tryy)) {
                        break;
                    }
                    x = x + di;
                    y = y + dj;
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }
}
