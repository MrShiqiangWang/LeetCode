package history.pkg201906;

import java.util.ArrayList;
import java.util.List;

public class SurroundArea {

    class ReservedSpace {

        int x;
        int y;
    }

    public static void main(final String[] args) {
        final char[][] a = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', 'X' } };

        new SurroundArea().solve(a);
    }

    public void solve(final char[][] board) {
        final List<ReservedSpace> list = new ArrayList<>();
        if (board.length <= 1) {
            return;
        }
        if (board[0].length <= 1) {
            return;
        }
        // 第一�?
        final char[] boardOne = board[0];
        for (int i = 0; i < boardOne.length; i++) {
            if (boardOne[i] == 'O') {
                this.reserve(0, i, board, list);
            }
        }

        // �?后一�?
        final char[] boardEnd = board[board.length - 1];
        for (int i = 0; i < boardEnd.length; i++) {
            if (boardEnd[i] == 'O') {
                this.reserve(board.length - 1, i, board, list);
            }
        }
        // 第一�?
        final int lie = board.length;
        for (int i = 0; i < lie; i++) {
            if (board[i][0] == 'O') {
                this.reserve(i, 0, board, list);
            }
        }
        // �?后一�?
        for (int i = 0; i < lie; i++) {
            if (board[i][boardOne.length - 1] == 'O') {
                this.reserve(i, boardOne.length - 1, board, list);
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

    private void reserve(final int x, final int y, final char[][] board, final List<ReservedSpace> list) {
        final int yMax = board[0].length;
        final int xMax = board.length;
        final int xMin = 0;
        final int yMin = 0;
        if (list.stream().filter(r -> r.x == x && r.y == y).findAny().isPresent()) {
            return;
        }
        if (x < xMax && x >= xMin && y < yMax && y >= yMin) {
            //
            if (board[x][y] == 'O') {
                final ReservedSpace reservedSpace = new ReservedSpace();
                reservedSpace.x = x;
                reservedSpace.y = y;
                list.add(reservedSpace);

                this.reserve(x - 1, y, board, list);
                this.reserve(x + 1, y, board, list);

                this.reserve(x, y - 1, board, list);
                this.reserve(x, y + 1, board, list);

            }
        }
        else {
            return;
        }
    }
}
