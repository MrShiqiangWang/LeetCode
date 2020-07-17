package pkg202007;

public class L13 {

    public int romanToInt(final String s) {
        final char[] cs = s.toCharArray();
        int i = 0;
        int sum = 0;
        for (; i < cs.length;) {
            if (cs[i] == 'I') {
                if (i + 1 < cs.length) {
                    if (cs[i + 1] == 'V') {
                        sum += 4;
                        i = i + 2;
                    }
                    else if (cs[i + 1] == 'X') {
                        sum += 9;
                        i = i + 2;
                    }
                    else {
                        sum++;
                        i++;
                    }
                }
                else {
                    sum++;
                    i++;
                }
            }
            else if (cs[i] == 'V') {
                sum += 5;
                i++;
            }
            else if (cs[i] == 'X') {
                if (i + 1 < cs.length) {
                    if (cs[i + 1] == 'L') {
                        sum += 40;
                        i = i + 2;
                    }
                    else if (cs[i + 1] == 'C') {
                        sum += 90;
                        i = i + 2;
                    }
                    else {
                        sum += 10;
                        i++;
                    }
                }
                else {
                    sum += 10;
                    i++;
                }
            }
            else if (cs[i] == 'L') {
                sum += 50;
                i++;
            }
            else if (cs[i] == 'C') {
                if (i + 1 < cs.length) {
                    if (cs[i + 1] == 'D') {
                        sum += 400;
                        i = i + 2;
                    }
                    else if (cs[i + 1] == 'M') {
                        sum += 900;
                        i = i + 2;
                    }
                    else {
                        sum += 100;
                        i++;
                    }
                }
                else {
                    sum += 100;
                    i++;
                }
            }
            else if (cs[i] == 'D') {
                sum += 500;
                i++;
            }
            else if (cs[i] == 'M') {
                sum += 1000;
                i++;
            }
        }
        return sum;
    }
}
