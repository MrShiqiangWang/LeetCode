package history.pkg201907;

public class RotateString {

    public static void main(final String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "abced"));
    }

    public boolean rotateString(final String A, final String B) {
        final char[] achars = A.toCharArray();
        final char[] bchars = B.toCharArray();

        if (achars.length != bchars.length) {
            return false;
        }
        int i = 0;
        int j = 0;

        while (i < achars.length && j < bchars.length) {
            j = 0;
            // �ҵ�i�е�һ����achars��ͬ���ַ�
            while (i < achars.length && achars[i] != bchars[j]) {
                i++;
            }
            if (i == achars.length && achars[i - 1] != bchars[j]) {
                return false;
            }

            int tmpI = i;
            while (j < bchars.length && achars[tmpI] == bchars[j]) {
                tmpI++;
                if (tmpI == achars.length) {
                    tmpI = 0;
                }
                j++;
            }

            if (j == bchars.length) {
                return true;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
