package pkg202007;

public class L434 {

    public static void main(String[] args) {
        System.out.println(
                new L434().countSegments("s"));
    }

    public int countSegments(String s) {
        char[] cs = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                if (i - 1 < 0 || i - 1 >= 0 && cs[i - 1] == ' ') {
                    continue;
                }
                sum++;
            }
        }
        if (cs[cs.length - 1] != ' ') {
            sum++;
        }
        return sum;
    }
}
