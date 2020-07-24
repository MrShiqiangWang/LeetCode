package pkg202007;

public class L13_1 {

    public int romanToInt(final String s) {
        final char[] cs = s.toCharArray();
        int pre = this.getValue(cs[0]);
        int sum = pre;
        int val;
        for (int i = 1; i < cs.length; i++) {
            val = this.getValue(cs[i]);
            if (val <= pre) {
                sum += val;
                pre = val;
            }
            else {
                sum -= val;
                pre = val;
            }
        }
        return sum;
    }

    private int getValue(final char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
