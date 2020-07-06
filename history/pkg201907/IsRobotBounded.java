package history.pkg201907;

public class IsRobotBounded {

    public boolean isRobotBounded(final String instructions) {
        final int[] position = new int[2];
        final int[] directions = { 'N', 'E', 'S', 'W' };

        int currentPosition = 0;

        final char[] instructionDirections = instructions.toCharArray();

        for (int i = 0; i < instructionDirections.length; i++) {
            // ����ÿ��ָ��
            switch (instructionDirections[i]) {
                case 'G':
                    final int direct = directions[currentPosition];
                    if (direct == 'N') {
                        // y��+1
                        position[1] = position[1] + 1;
                    }
                    if (direct == 'S') {
                        position[1] = position[1] - 1;
                    }
                    if (direct == 'W') {
                        position[0] = position[0] - 1;
                    }
                    if (direct == 'E') {
                        position[0] = position[0] + 1;
                    }
                    break;
                case 'L':
                    if (currentPosition == 0) {
                        currentPosition = 3;
                    }
                    else {
                        currentPosition = (currentPosition - 1) % 4;
                    }
                    break;
                case 'R':
                    currentPosition = (currentPosition + 1) % 4;
                    break;
                default:
                    break;
            }
        }
        if (position[0] == 0 && position[1] == 0) {
            return true;
        }
        if (currentPosition != 0) {
            return true;
        }
        return false;
    }
}
