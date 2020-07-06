package history.pkg201906;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        solution.numJewelsInStones("ababab", "");
    }

    public int numJewelsInStones(final String J, final String S) {
        final Set<Character> character = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            character.add(J.charAt(i));
        }

        int number = 0;
        for (int j = 0; j < S.length(); j++) {
            if (character.contains(S.charAt(j))) {
                number++;
            }
        }
        return number;
    }
}
