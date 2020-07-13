package pkg202007;

public class L762 {

    public int countPrimeSetBits(final int L, final int R) {
        int counter = 0;
        for (int i = L; i <= R; i++) {
            final char[] cs = Integer.toUnsignedString(i, 2).toCharArray();
            int size = 0;
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == '1') {
                    size++;
                }
            }
            if (this.isPrime(size)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isPrime(final int num) {
        final int k = (int) Math.sqrt(num);// kΪnum����ƽ������ȡ����
        for (int i = 2; i <= k; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
