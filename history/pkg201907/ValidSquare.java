package history.pkg201907;

public class ValidSquare {

    public static void main(final String[] args) {
        final int[] p1 = { 0, 0 };
        final int[] p2 = { 0, 0 };
        final int[] p3 = { 0, 0 };
        final int[] p4 = { 0, 0 };

        System.out.println(new ValidSquare().validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
        // ���� ǰ�������Ǳ�
        // p1 p2,p3 Ϊֱ�Ǳ�
        boolean result = false;
        result |= this.testSqure(p1, p2, p3, p4);
        result |= this.testSqure(p1, p2, p4, p3);
        result |= this.testSqure(p1, p3, p2, p4);
        result |= this.testSqure(p1, p3, p4, p2);
        return result;

    }

    private boolean testSqure(final int[] p1, final int[] p2, final int[] p3, final int[] p4) {
        final int xd = p2[0] - p1[0];
        final int yd = p2[1] - p1[1];

        // p3��p1������
        final int xd1 = p3[0] - p1[0];
        final int yd1 = p3[1] - p1[1];

        if (xd * xd1 + yd * yd1 == 0) {
            // ��Ҫ����ߵĳ����Ƿ����
            final int xdis = (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
            final int ydis = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
            if (xdis == 0 || ydis == 0) {
                return false;
            }
            if (xdis == ydis) {
                if (p4[0] + p1[0] == p3[0] + p2[0] && p4[1] + p1[1] == p3[1] + p2[1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
