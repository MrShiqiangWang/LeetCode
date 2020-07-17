package pkg202007;

public class L171 {

    public static void main(String[] args) {
        System.out.println(new L171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            sum = sum * 26 + cs[i] - 64;
        }
        return sum;
    }
}
