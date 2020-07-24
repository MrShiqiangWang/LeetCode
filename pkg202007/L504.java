package pkg202007;

public class L504 {

    public String convertToBase7(final int num) {
        if (num < 0) {
            return "-" + Integer.toString(-num, 7);
        }
        return Integer.toString(num, 7);
    }
}
