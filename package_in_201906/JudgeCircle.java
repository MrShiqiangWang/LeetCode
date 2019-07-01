package package_in_201906;

public class JudgeCircle {

    class Position {

        int x = 0;
        int y = 0;
    }

    public boolean judgeCircle2(String moves) {
        char[] characters = moves.toCharArray();
        int x = 0;
        int y = 0;
        for (char c : characters) {
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

    public boolean judgeCircle(String moves) {
        Position position = new Position();
        char[] moveChars = moves.toCharArray();
        int size = moveChars.length;
        for (int i = 0; i < size; i++) {
            Character character = moveChars[i];
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
}
