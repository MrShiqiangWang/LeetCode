package powerfulintegers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class PowerfulIntegers {
	
	public static void main(String[] args) {
		System.out.println(new PowerfulIntegers().powerfulIntegers(2, 1, 10));
	}
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		int xm = 0;
		int i = 0;
		Set<Integer> set = new HashSet<>();
		while (xm <= bound) {
			xm = (int) Math.pow(x, i);
			int ym = xm;
			int j = 0;
			while (ym <= bound) {
				ym = ((int) Math.pow(y, j)) + xm;
				if (ym <= bound) {
					set.add(ym);
				}
				j++;
				if (y == 1) {
					break;
				}
			}
			if (x == 1) {
				break;
			}
			i++;
		}
		List<Integer> result = set.stream().collect(Collectors.toList());
		Collections.sort(result, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}

		});
		return result;
	}
}
