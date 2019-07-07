package package_in_201907;

public class DistributeCandies {
	public int[] distributeCandies(int candies, int num_people) {
		int[] tangs = new int[num_people];
		int tang = 1;
		int index = 0;
		while (candies > 0) {
			if (index == num_people) {
				index = 0;
			}

			if (candies - tang > 0) {
				candies -= tang;
				tangs[index] += tangs[index] + tang;
			} else {
				candies = 0;
				tangs[index] += tangs[index] + candies;
			}

			tang++;
			index++;
		}
		return tangs;
	}
}
