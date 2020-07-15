package pkg202007;

public class L13 {

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int sum = 0;
        for (; i < cs.length;) {
            if (cs[i] == 'I') {

            }
            else if (cs[i] == 'V') {
                sum += 5;
                i++;
            }
            else if (cs[i] == 'X') {

            }
            else if (cs[i] == 'L') {
                sum += 50;
                i++;
            }
            else if (cs[i] == 'C') {
                sum += 100;
                i++;
            }
            else if (cs[i] == 'D') {

            }
            else if (cs[i] == 'M') {

            }
        }
    }
}
