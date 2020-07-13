package pkg202007;

public class M05_03 {

    public static void main(final String[] args) {
        System.out.println(new M05_03().reverseBits(2147483646));
    }

    public int reverseBits(final int num) {
        final char[] cs = Integer.toBinaryString(num).toCharArray();
        int max = 1;
        int numOfZero = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                numOfZero++;
                max = Math.max(this.getLongest(cs, i), max);
            }
        }
        if (numOfZero == 0) {
            max = cs.length + 1;
        }
        return max;
    }

    private int getLongest(final char[] cs, final int index) {
        int sum = 1;
        for (int i = index - 1; i >= 0 && cs[i] == '1'; i--) {
            sum++;
        }
        for (int i = index + 1; i < cs.length && cs[i] == '1'; i++) {
            sum++;
        }
        return sum;
    }
}
