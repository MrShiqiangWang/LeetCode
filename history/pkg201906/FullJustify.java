package history.pkg201906;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {

    public static void main(final String[] args) {
        final String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        System.out.println(new FullJustify().fullJustify(words, 16));
    }

    public List<String> fullJustify(final String[] words, final int maxWidth) {
        int width = 0;
        final List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(words[0]);
        width = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (width + words[i].length() + 1 > maxWidth) {
                // �����ַ���
                final String string = this.from(tmp, maxWidth, false);
                result.add(string);
                tmp = new ArrayList<>();
                tmp.add(words[i]);
                width = words[i].length();
            }
            else {
                tmp.add(words[i]);
                width += words[i].length() + 1;
            }
        }
        final String tmpStr = this.from(tmp, maxWidth, true);
        result.add(tmpStr);
        return result;
    }

    private String from(final List<String> tmp, final int maxWidth, final boolean last) {
        if (last) {
            final StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < tmp.size(); i++) {
                stringBuffer.append(tmp.get(i));
                if (i != tmp.size() - 1) {
                    stringBuffer.append(' ');
                }
            }
            final int l = stringBuffer.toString().length();
            for (int i = 0; i < maxWidth - l; i++) {
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
        if (tmp.size() == 1) {
            final int l = tmp.get(0).length();
            final StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tmp.get(0));
            for (int i = 0; i < maxWidth - l; i++) {
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
        else {
            int size = 0;
            for (int i = 0; i < tmp.size(); i++) {
                size += tmp.get(i).length();
            }
            final int space = (maxWidth - size) / (tmp.size() - 1);
            final StringBuffer stringBuffer = new StringBuffer();
            final int t = (maxWidth - size) % (tmp.size() - 1);
            for (int i = 0; i < tmp.size() - 1; i++) {
                stringBuffer.append(tmp.get(i));
                for (int j = 0; j < space; j++) {
                    stringBuffer.append(' ');
                }
                if (i == 0) {
                    for (int j = 0; j < t; j++) {
                        stringBuffer.append(' ');
                    }
                }
            }
            stringBuffer.append(tmp.get(tmp.size() - 1));
            return stringBuffer.toString();
        }
    }
}
