package pkg202007;

import java.util.Arrays;

public class L67 {

	public static void main(String[] args) {
		System.out.println(new L67().addBinary("11", "1"));
	}

	public String addBinary(String a, String b) {
		char[] as = a.toCharArray();
		char[] bs = b.toCharArray();
		char[] re = new char[Math.max(as.length, bs.length) + 1];
		int counter = re.length - 1;
		int jinwei = 0;
		for (int i = as.length - 1, j = bs.length - 1; i >= 0 || j >= 0;) {
			if (i >= 0 && j >= 0) {
				re[counter] = (char) ((as[i] + bs[j] - 96 + jinwei) % 2 + 48);
				jinwei = (as[i] + bs[j] - 96 + jinwei) / 2;
				i--;
				j--;
			} else if (i >= 0) {
				re[counter] = (char) ((as[i] - 48 + jinwei) % 2 + 48);
				jinwei = (as[i] - 48 + jinwei) / 2;
				i--;
			} else {
				re[counter] = (char) ((bs[j] - 48 + jinwei) % 2 + 48);
				jinwei = (bs[j] - 48 + jinwei) / 2;
				j--;
			}
			counter--;
		}
		if (jinwei == 0) {
			return new String(Arrays.copyOfRange(re, 1, re.length));
		}
		re[0] = '1';
		return new String(re);
	}
}
