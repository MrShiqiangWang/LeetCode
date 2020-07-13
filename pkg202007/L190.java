package pkg202007;

import java.math.BigInteger;

public class L190 {

    public static void main(final String[] args) {
        System.out.println(new L190().reverseBits(new BigInteger("11111111111111111111111111111101", 2).intValue()));
    }

    public int reverseBits(final int n) {
        final char[] array = Integer.toBinaryString(n).toCharArray();
        final char[] result = new char[32];
        for (int i = 0; i < 32; i++) {
            result[i] = '0';
        }
        for (int i = array.length - 1; i >= 0; i--) {
            result[array.length - i - 1] = array[i];
        }
        return Integer.parseUnsignedInt(new String(result), 2);
    }
}
