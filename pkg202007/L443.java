package pkg202007;

import java.util.Arrays;

public class L443 {

    public int compress(char[] chars) {
        int counter = 0;
        int sum = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                sum++;
            }
            else {
                if (sum == 1) {
                    chars[counter] = chars[i - 1];
                    counter++;
                }
                else {
                    chars[counter] = chars[i - 1];
                    counter++;
                    char[] sumChars = String.valueOf(sum).toCharArray();
                    for (int j = 0; j < sumChars.length; j++) {
                        chars[counter] = sumChars[j];
                        counter++;
                    }

                }
                sum = 1;
            }
        }
        if (sum == 1) {
            chars[counter] = chars[chars.length - 1];
            counter++;
        }
        else {
            chars[counter] = chars[chars.length - 1];
            counter++;
            char[] sumChars = String.valueOf(sum).toCharArray();
            for (int j = 0; j < sumChars.length; j++) {
                chars[counter] = sumChars[j];
                counter++;
            }
        }
        return counter;
    }
}
