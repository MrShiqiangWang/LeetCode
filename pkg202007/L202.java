package pkg202007;

public class L202 {

    public static void main(final String[] args) {
        System.out.println(new L202().isHappy(2));
    }

    public boolean isHappy(int n) {
        final int begin = n;
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
            if (n == 0) {
                if (sum == 1) {
                    return true;
                }
                else {
                    if (sum == begin) {
                        return false;
                    }
                    n = sum;
                    sum = 0;
                }
            }
        }
        return false;
    }
}
