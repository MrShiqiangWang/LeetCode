package package_in_201906;

import java.util.ArrayList;
import java.util.List;

public class SurroundArea {

    public static void main(String[] args) {
        char[][] a = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', 'X' } };

        new SurroundArea().solve(a);
    }

    class ReservedSpace {

        int x;
        int y;
    }

    public void solve(char[][] board) {
        List<ReservedSpace> list = new ArrayList<>();
        if (board.length <= 1) {
            return;
        }
        if (board[0].length <= 1) {
            return;
        }
        // ç¬¬ä¸€è¡?
        char[] boardOne = board[0];
        for (int i = 0; i < boardOne.length; i++) {
            if (boardOne[i] == 'O') {
                reserve(0, i, board, list);
            }
        }

        // æœ?åŽä¸€è¡?
        char[] boardEnd = board[board.length - 1];
        for (int i = 0; i < boardEnd.length; i++) {
            if (boardEnd[i] == 'O') {
                reserve(board.length - 1, i, board, list);
            }
        }
        // ç¬¬ä¸€åˆ?
        int lie = board.length;
        for (int i = 0; i < lie; i++) {
            if (board[i][0] == 'O') {
                reserve(i, 0, board, list);
            }
        }
        // æœ?åŽä¸€åˆ?
        for (int i = 0; i < lie; i++) {
            if (board[i][boardOne.length - 1] == 'O') {
                reserve(i, boardOne.length - 1, board, list);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    final int k = i;
                    final int s = j;
                    if (list.stream().filter(r -> r.x == k && r.y == s).findAny().isPresent()) {
                        continue;
                    }
                    else {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private void reserve(int x, int y, char[][] board, List<ReservedSpace> list) {
        int yMax = board[0].length;
        int xMax = board.length;
        int xMin = 0;
        int yMin = 0;
        if (list.stream().filter(r -> r.x == x && r.y == y).findAny().isPresent()) {
            return;
        }
        if (x < xMax && x >= xMin && y < yMax && y >= yMin) {
            //
            if (board[x][y] == 'O') {
                ReservedSpace reservedSpace = new ReservedSpace();
                reservedSpace.x = x;
                reservedSpace.y = y;
                list.add(reservedSpace);

                reserve(x - 1, y, board, list);
                reserve(x + 1, y, board, list);

                reserve(x, y - 1, board, list);
                reserve(x, y + 1, board, list);

            }
        }
        else {
            return;
        }
    }
}
