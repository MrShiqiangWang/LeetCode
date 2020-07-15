package pkg202007;

public class L13 {
	public int romanToInt(String s) {
		char[] cs = s.toCharArray();

		int result = 0;
		int i = 0;
		for (; i < cs.length;) {
			if (cs[i] == 'I') {
				// 检测下一个数字
				if (i + 1 < cs.length) {
					if(cs[i+1]=='V') {
						
					}else if(cs[i+1])
				} else {
					result += 1;
					i++;
				}
			} else if (cs[i] == 'V') {
				result += 5;
			} else if (cs[i] == 'X') {

			} else if (cs[i] == 'L') {
				result += 50;
			} else if (cs[i] == 'C') {

			} else if (cs[i] == 'D') {
				result += 500;
			} else {
				result += 1000;
			}
		}
		return 0;
	}
}
