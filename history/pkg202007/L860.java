package history.pkg202007;

public class L860 {

    public static void main(final String[] args) {

    }

    public boolean lemonadeChange(final int[] bills) {
        // 零钱
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    }
                    five = five - 3;
                }
                else {
                    if (five < 1) {
                        return false;
                    }
                    five--;
                    ten--;
                }
            }
        }
        return true;
    }
}
