package robotsim;

public class RobotSim {

	public static void main(String[] args) {
		System.out.println(-1 % 4);
	}

	class Robot {
		int direction = 0;
		int x = 0;
		int y = 0;
	}

	public int robotSim(int[] commands, int[][] obstacles) {
		char directions[] = { 'n', 'e', 's', 'w' };
		Robot robot = new Robot();
		for (int i = 0; i < commands.length; i++) {
			// 改变方向
			if (commands[i] == -1) {
				robot.direction = (robot.direction + 1) % 4;
				continue;
			}
			// 改变方向
			if (commands[i] == -2) {
				robot.direction = (robot.direction - 1) % 4;
				if (robot.direction < 0) {
					robot.direction = robot.direction + 4;
				}
				continue;
			}
			move(robot, obstacles, commands[i], directions[robot.direction]);
		}
		return robot.x * robot.x + robot.y * robot.y;
	}

	private void move(Robot robot, int[][] obstacles, int n, char direction) {
		if (direction == 'n') {
			for (int i = 0; i < n; i++) {
				if (check(robot.x, robot.y + 1, obstacles)) {
					robot.y = robot.y + 1;
				}
			}
		}
		if (direction == 's') {
			for (int i = 0; i < n; i++) {
				if (check(robot.x, robot.y - 1, obstacles)) {
					robot.y = robot.y - 1;
				}
			}
		}

		if (direction == 'e') {
			for (int i = 0; i < n; i++) {
				if (check(robot.x + 1, robot.y, obstacles)) {
					robot.x = robot.x + 1;
				}
			}
		}
		if (direction == 'w') {
			for (int i = 0; i < n; i++) {
				if (check(robot.x - 1, robot.y, obstacles)) {
					robot.x = robot.x - 1;
				}
			}
		}
	}

	private boolean check(Integer x, Integer y, int[][] obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			if (obstacles[i][0] == x && obstacles[i][1] == y) {
				return false;
			}
		}
		return true;
	}
}