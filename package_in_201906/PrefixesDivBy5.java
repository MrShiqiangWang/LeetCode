package package_in_201906;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrefixesDivBy5 {

	public static void main(String[] args) {
		int[] A = { 1, 1, 1 };
		System.out.println(new PrefixesDivBy5().prefixesDivBy5(A));
	}

	public List<Boolean> prefixesDivBy5(int[] A) {
		List<Boolean> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			if (queue.size() < 4) {
				queue.add(A[i]);
			} else {
				queue.poll();
				queue.add(A[i]);
			}
			if (test(queue)) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

	private boolean test(Queue<Integer> queue) {
		StringBuffer stringBuffer = new StringBuffer();
		for (Integer va : queue) {
			stringBuffer.append(va + "");
		}
		int v = new BigInteger(stringBuffer.toString(), 2).intValue();
		if (v == 0) {
			return true;
		}
		return v % 5 == 0;
	}

}
