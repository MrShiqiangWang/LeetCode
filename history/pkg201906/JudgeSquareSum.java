package history.pkg201906;

public class JudgeSquareSum {

    public boolean judgeSquareSum(final int c) {
        final int count = (int) Math.sqrt(c);
        for (int i = 0; i < count; i++) {
            final int a = (int) Math.sqrt(c - i * i);
            if (a * a + i * i == c) {
                return true;
            }
        }
        return false;
    }
}
