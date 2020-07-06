package history.pkg201906;

public class RobotSim {

    class Robot {

        int direction = 0;
        int x = 0;
        int y = 0;
    }

    public static void main(final String[] args) {
        System.out.println(-1 % 4);
    }

    public int robotSim(final int[] commands, final int[][] obstacles) {
        final char directions[] = { 'n', 'e', 's', 'w' };
        final Robot robot = new Robot();
        for (int i = 0; i < commands.length; i++) {
            // �ı䷽��
            if (commands[i] == -1) {
                robot.direction = (robot.direction + 1) % 4;
                continue;
            }
            // �ı䷽��
            if (commands[i] == -2) {
                robot.direction = (robot.direction - 1) % 4;
                if (robot.direction < 0) {
                    robot.direction = robot.direction + 4;
                }
                continue;
            }
            this.move(robot, obstacles, commands[i], directions[robot.direction]);
        }
        return robot.x * robot.x + robot.y * robot.y;
    }

    private boolean check(final Integer x, final Integer y, final int[][] obstacles) {
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == x && obstacles[i][1] == y) {
                return false;
            }
        }
        return true;
    }

    private void move(final Robot robot, final int[][] obstacles, final int n, final char direction) {
        if (direction == 'n') {
            for (int i = 0; i < n; i++) {
                if (this.check(robot.x, robot.y + 1, obstacles)) {
                    robot.y = robot.y + 1;
                }
            }
        }
        if (direction == 's') {
            for (int i = 0; i < n; i++) {
                if (this.check(robot.x, robot.y - 1, obstacles)) {
                    robot.y = robot.y - 1;
                }
            }
        }

        if (direction == 'e') {
            for (int i = 0; i < n; i++) {
                if (this.check(robot.x + 1, robot.y, obstacles)) {
                    robot.x = robot.x + 1;
                }
            }
        }
        if (direction == 'w') {
            for (int i = 0; i < n; i++) {
                if (this.check(robot.x - 1, robot.y, obstacles)) {
                    robot.x = robot.x - 1;
                }
            }
        }
    }
}
