package history.pkg202007;

public class M05_06 {

    public static void main(final String[] args) {
        System.out.println(new M05_06().convertInteger(528611498, -1619967984));
    }

    public int convertInteger(final int A, final int B) {
        return Integer.bitCount(A ^ B);
    }
}
