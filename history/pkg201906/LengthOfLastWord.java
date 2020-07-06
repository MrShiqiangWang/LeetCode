package history.pkg201906;

public class LengthOfLastWord {

    public int lengthOfLastWord(final String s) {
        final String[] result = s.trim().split(" ");
        if (result.length == 0) {
            return 0;
        }
        return result[result.length - 1].length();
    }
}
