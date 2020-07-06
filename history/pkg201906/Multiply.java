package history.pkg201906;

public class Multiply {

    public static void main(final String[] args) {
        System.out.println(new Multiply().multiply("0", "0"));
    }

    public String multiply(final String num1, final String num2) {
        final char[] nums1 = num1.toCharArray();
        final char[] nums2 = num2.toCharArray();
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) {
            return "";
        }
        final int[] result = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                final int x = (nums1[n1 - i - 1]) - 48;
                final int y = (nums2[n2 - j - 1]) - 48;
                final int z = x * y;
                final int mode = z % 10;
                final int div = z / 10;
                result[i + j + 1] = result[i + j + 1] + div;
                result[i + j] = result[i + j] + mode;
            }
        }

        for (int i = 0; i < n1 + n2 - 1; i++) {
            result[i + 1] += (result[i] / 10);
            result[i] = result[i] % 10;
        }

        final StringBuffer buffer = new StringBuffer();
        boolean zerodel = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!zerodel) {
                if (result[i] != 0) {
                    zerodel = true;
                    buffer.append(result[i] + "");
                }
            }
            else {
                buffer.append(result[i]);
            }
        }
        if (buffer.toString().equals("")) {
            return "0";
        }
        return buffer.toString();
    }
}
