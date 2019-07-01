package package_in_201906;

public class ReachNumber {
	public static void main(String[] args) {
		System.out.println(new ReachNumber().reachNumber(2));
	}

	public int reachNumber(int target) {
		int x = (int) Math.floor(Math.sqrt(2 * Math.abs(target)));
		int pos = (x * x + x) / 2;
		int newTarget = Math.abs(Math.abs(target) - pos);
		return x +  newTarget;
	}
}
