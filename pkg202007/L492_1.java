package pkg202007;

public class L492_1 {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        int[] re = { area / w, w };
        return re;
    }
}
