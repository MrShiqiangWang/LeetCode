package history.pkg201906;

public class JudgeCircle {

    class Position {

        int x = 0;
        int y = 0;
    }

    public boolean judgeCircle(final String moves) {
        final Position position = new Position();
        final char[] moveChars = moves.toCharArray();
        final int size = moveChars.length;
        for (int i = 0; i < size; i++) {
            final Character character = moveChars[i];
            switch (character) {
                case 'L':
                    position.x--;
                    break;
                case 'R':
                    position.x++;
                    break;
                case 'U':
                    position.y++;
                    break;
                case 'D':
                    position.y--;
                    break;

                default:
                    break;
            }
        }
        return position.x == 0 && position.y == 0;
    }

    public boolean judgeCircle2(final String moves) {
        final char[] characters = moves.toCharArray();
        int x = 0;
        int y = 0;
        for (final char c : characters) {
            switch (c) {
                case 'L':
                    x++;
                    break;
                case 'R':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;

                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
