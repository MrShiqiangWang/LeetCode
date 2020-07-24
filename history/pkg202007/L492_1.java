package history.pkg202007;

public class L492_1 {

    public int[] constructRectangle(final int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        final int[] re = { area / w, w };
        return re;
    }
}
