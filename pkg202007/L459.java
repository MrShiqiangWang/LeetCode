package pkg202007;

public class L459 {

    public boolean repeatedSubstringPattern(final String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.append(s);
        return builder.toString().substring(1, builder.length() - 1).contains(s);
    }
}
