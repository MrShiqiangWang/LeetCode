package pkg202007;

public class L492 {

    public int[] constructRectangle(int area) {
        int w = 1, l = area;
        int lastl = area;
        int lastW = 1;
        while (w<=l) {
            if (l * w < area) {
                w++;
            }
            else if (l * w > area) {
                l--;
            }
            else {
                lastl = l;
                lastW = w;
                w++;
                l--;
            }
        }
        int[] re = { lastl, lastW };
        return re;
    }
}
