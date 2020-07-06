package history.pkg201907;

import java.util.HashSet;
import java.util.Set;

public class CheckPerfectNumber {

    public static void main(final String[] args) {
        System.out.println(new CheckPerfectNumber().checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(final int num) {
        if (num == 1) {
            return false;
        }
        final int max = (int) Math.sqrt(num);
        //
        int i = 2;

        final Set<Integer> set = new HashSet<>();

        while (i <= max) {
            // �ж�i�ǲ�������

            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
            i++;
        }

        //
        int sum = 0;
        for (final Integer item : set) {
            sum += item;
        }

        sum++;

        if (sum == num) {
            return true;
        }
        return false;
    }
}
