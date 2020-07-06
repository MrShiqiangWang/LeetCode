package history.pkg201907;

import java.util.Arrays;
import java.util.Comparator;

public class IsAlienSorted {

    public boolean isAlienSorted(final String[] words, final String order) {
        final String[] newWords = Arrays.copyOfRange(words, 0, words.length);

        Arrays.sort(newWords, new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                final char[] o1s = o1.toCharArray();
                final char[] o2s = o2.toCharArray();
                // ����
                for (int i = 0; i < o1s.length && i < o2s.length; i++) {
                    if (o1s[i] != o2s[i]) {
                        // �Ƚ϶�Ӧ���ַ����ַ���order�е�λ��
                        final int inO1 = order.indexOf(o1s[i]);
                        final int inO2 = order.indexOf(o2s[i]);
                        if (inO1 < inO2) {
                            return -1;
                        }
                    }
                }
                if (o1s.length == o2s.length) {
                    return 0;
                }
                if (o1.length() < o2s.length) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < newWords.length; i++) {
            if (!newWords[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
