package history.pkg202007;

public class L717 {

    public boolean isOneBitCharacter(final int[] bits) {
        boolean last = false;
        for (int i = 0; i < bits.length;) {
            if (bits[i] == 1) {
                i = i + 2;
                last = false;
            }
            else {
                last = true;
                i++;
            }
        }
        return last;
    }
}
