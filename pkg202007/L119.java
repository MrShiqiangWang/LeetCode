package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L119 {

	public static void main(String[] args) {
		System.out.println(new L119().getRow(3).toString());
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0) {
				result.add(1);
				continue;
			}
			result.add(0);
		}
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j >= 1; j--) {
				if (j == i) {
					result.set(j, 1);
					continue;
				}
				result.set(j, result.get(j - 1) + result.get(j));
			}
		}
		return result;
	}

}
