package history.pkg202007;

public class M16_11 {

    public int[] divingBoard(final int shorter, final int longer, final int k) {
        final int increment = longer - shorter;
        int min = shorter * k;
        final int max = longer * k;

        if (k == 0) {
            return new int[0];
        }
        if (increment == 0) {
            final int[] result = { k * increment };
            return result;
        }
        final int result[] = new int[k + 1];
        int i = 0;
        while (min <= max) {
            result[i] = min;
            min = min + increment;
            i++;
        }
        return result;
    }
}
