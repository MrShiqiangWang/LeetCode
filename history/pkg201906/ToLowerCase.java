package history.pkg201906;

public class ToLowerCase {

    public static void main(final String[] args) {
        System.out.println((int) 'z');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'A');
    }

    public String toLowerCase(final String str) {
        final StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                stringBuffer.append((char) (c + 32));
            }
            else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();

    }
}
