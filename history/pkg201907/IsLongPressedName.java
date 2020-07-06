package history.pkg201907;

public class IsLongPressedName {

    public boolean isLongPressedName(final String name, final String typed) {
        final char names[] = name.toCharArray();
        final char typeds[] = typed.toCharArray();

        int k = 0;
        for (int i = 0; i < typeds.length; i++) {
            if (typeds[i] == names[k]) {
                k++;
                if (k == names.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
