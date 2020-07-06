package history.pkg201906;

public class ReachNumber {

    public static void main(final String[] args) {
        System.out.println(new ReachNumber().reachNumber(2));
    }

    public int reachNumber(final int target) {
        final int x = (int) Math.floor(Math.sqrt(2 * Math.abs(target)));
        final int pos = (x * x + x) / 2;
        final int newTarget = Math.abs(Math.abs(target) - pos);
        return x + newTarget;
    }
}
