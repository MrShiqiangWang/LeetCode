package pkg202007;

import java.util.ArrayList;
import java.util.List;

public class L500 {

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (isSameLine(words[i])) {
                result.add(words[i]);
            }
        }
        String[] re = new String[result.size()];
        return result.toArray(re);
    }

    private boolean isSameLine(String word) {
        String[] keyboards = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        char[] cs = word.toCharArray();
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
