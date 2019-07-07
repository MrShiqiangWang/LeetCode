package package_in_201907;

public class NumPairsDivisibleBy60 {
	public int numPairsDivisibleBy60Low(int[] time) {
		int sum = 0;
		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if ((time[i] + time[j]) % 60 == 0) {
					sum++;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 30, 20, 150, 100, 40 };

		System.out.println(new NumPairsDivisibleBy60().numPairsDivisibleBy60(nums));
	}

	public int numPairsDivisibleBy60(int[] time) {
        int[] index = new int[60];

		for (int i = 0; i < time.length; i++) {
			int myIndex = time[i] % 60;
			index[myIndex] = index[myIndex] + 1;
		}

		int sum = 0;
		for (int i = 0; i < index.length; i++) {
			if (index[i] != 0) {
				int newIndex = (60 - i)%60;
				if (newIndex > i) {
					sum += (index[i] * index[newIndex]);
				}
				if (newIndex == i) {
					sum += index[i] * (index[i] - 1) / 2;
				}
			}
		}
		return sum;
	}
}
