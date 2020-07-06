package history.pkg201907;

import java.math.BigInteger;

public class FindComplement {

    public static void main(final String[] args) {
        System.out.println(BigInteger.valueOf(5).toString(2));
    }

    public int findComplement(final int num) {
        // ת��Ϊ������
        // ȥ�������Ƶ�ǰ�浼λ 0
        final String binaryStr = BigInteger.valueOf(num).toString(2);
        // ��λȡ��
        final char[] result = binaryStr.toCharArray();

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

        // ȡ������
        final String strResult = new String(result);
        return new BigInteger(strResult, 2).intValue();
    }
}
