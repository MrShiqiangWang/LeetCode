package package_in_201907;

import java.math.BigInteger;

public class FindComplement {
	public static void main(String[] args) {
		System.out.println(BigInteger.valueOf(5).toString(2));
	}

	public int findComplement(int num) {
		// 转化为二进制
		// 去掉二进制的前面导位 0
		String binaryStr = BigInteger.valueOf(num).toString(2);
		// 按位取反
		char[] result = binaryStr.toCharArray();

		for (int i = 0; i < result.length; i++) {
			if (result[i] == '1') {
				result[i] = '0';
				continue;
			}
			if (result[i] == '0') {
				result[i] = '1';
				continue;
			}
		}

		// 取反后结果
		String strResult = new String(result);
		return new BigInteger(strResult, 2).intValue();
	}
}
