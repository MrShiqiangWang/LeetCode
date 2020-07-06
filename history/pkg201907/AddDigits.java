package history.pkg201907;

public class AddDigits {

    public static void main(final String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }

    public int addDigits(final int num) {
        int sum = num;
        while (sum >= 10) {
            final String numStr = String.valueOf(sum);
            // �õ�ÿһ��λ������
            final char[] chars = numStr.toCharArray();
            sum = 0;
            for (int i = 0; i < chars.length; i++) {
                sum += Integer.parseInt(chars[i] + "");
            }
        }
        return sum;
    }
}
