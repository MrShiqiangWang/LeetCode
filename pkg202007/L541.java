package pkg202007;

public class L541 {

    public static void main(String[] args) {
        System.out.println(new L541().reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int i = 0;
        for (; i < cs.length;) {
            if (i + k - 1 >= cs.length) {
                reverse(cs, i, cs.length - 1);
                break;
            }
            else {
                reverse(cs, i, i + k - 1);
                i = i + k;
            }
            i = i + k;
        }
        return new String(cs);
    }

    private void reverse(char[] cs, int left, int right) {
        char tmp;
        while (left < right) {
            tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            left++;
            right--;
        }
    }
}
