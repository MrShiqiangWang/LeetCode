package pkg202007;

import java.math.BigInteger;

import sun.reflect.generics.tree.IntSignature;

public class L7 {

	public static void main(String[] args) {
		// System.out.println(Integer.MAX_VALUE);
		new L7().reverse(1563847412);
	}

	public int reverse(int x) {
		int value = x;
		if (x < 0) {
			value = -x;
		}
		if (value < 0) {
			return 0;
		}
		char[] cs = Integer.toString(value).toCharArray();
		int left = 0;
		int right = cs.length - 1;
		while (left < right) {
			char temp = cs[left];
			cs[left] = cs[right];
			cs[right] = temp;
			left++;
			right--;
		}
		char[] cs2 = new BigInteger(new String(cs), 10).toString(2).toCharArray();
		if (cs2.length == 32 && cs2[0] == '1') {
			return 0;
		}
		if (x < 0) {
			return -Integer.parseInt(new String(cs));
		}
		return Integer.parseInt(new String(cs));
	}
}
