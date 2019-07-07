package package_in_201907;

public class IsRobotBounded {
	public boolean isRobotBounded(String instructions) {
		int[] position = new int[2];
		int[] directions = { 'N', 'E', 'S', 'W' };

		int currentPosition = 0;

		char[] instructionDirections = instructions.toCharArray();

		for (int i = 0; i < instructionDirections.length; i++) {
			// 遍历每个指令
			switch (instructionDirections[i]) {
			case 'G':
				int direct = directions[currentPosition];
				if (direct == 'N') {
					// y轴+1
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
				} else {
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
		if(currentPosition!=0) {
			return true;
		}
		return false;
	}
}
