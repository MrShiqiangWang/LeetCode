package package_in_201907;

import java.util.HashSet;
import java.util.Set;

public class CheckPerfectNumber {
	public static void main(String[] args) {
		System.out.println(new CheckPerfectNumber().checkPerfectNumber(28));
	}

	public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
		int max = (int) Math.sqrt(num);
		//
		int i = 2;

		Set<Integer> set = new HashSet<>();

		while (i <= max) {
			// 判断i是不是因子

			if (num % i == 0) {
				set.add(i);
				set.add(num / i);
			}
			i++;
		}

		//
		int sum = 0;
		for (Integer item : set) {
			sum += item;
		}

		sum++;

		if (sum == num) {
			return true;
		}
		return false;
	}
}
