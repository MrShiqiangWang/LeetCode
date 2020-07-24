package history.pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L500 {

    public String[] findWords(final String[] words) {
        final List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (this.isSameLine(words[i])) {
                result.add(words[i]);
            }
        }
        final String[] re = new String[result.size()];
        return result.toArray(re);
    }

    private boolean isSameLine(final String word) {
        final String[] keyboards = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        final char[] cs = word.toCharArray();
        int line = -1;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < keyboards.length; j++) {
                if (keyboards[j].contains(cs[i] + "")) {
                    if (line == -1) {
                        line = j;
                    }
                    else if (line != j) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
