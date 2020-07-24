package pkg202007;

public class M05_01 {

    public static void main(final String[] args) {
        System.out.println(new M05_01().insertBits(1024, 19, 2, 6));
    }

    public int insertBits(final int N, final int M, final int i, final int j) {
        final char[] ns = Integer.toBinaryString(N).toCharArray();
        final char[] ms = Integer.toBinaryString(M).toCharArray();

        final int size = ns.length > j ? ns.length : (i == 0 ? j + 1 : j);
        final char[] result = new char[size];
        for (int k = 0; k < size; k++) {
            if (k - (size - j) + 1 >= 0 && k - (size - j) + 1 < ms.length) {
                result[k] = ms[k - (size - j) + 1];
            }
            else {
                result[k] = ns[k - (size - ns.length)];
            }
        }
        return Integer.parseUnsignedInt(new String(result), 2);
    }
}
