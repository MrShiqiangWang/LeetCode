package pkg202007;

import java.util.Comparator;
import java.util.TreeSet;

public class L720_1 {

    private static class Node {

        // 构建字典表
        public static void buildDictionary(Node node, final String word) {
            final char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (node.nodes[cs[i] - 'a'] == null) {
                    node.nodes[cs[i] - 'a'] = new Node();
                    node = node.nodes[cs[i] - 'a'];
                }
                else {
                    node = node.nodes[cs[i] - 'a'];
                }
            }
            node.isEnd = true;
        }

        boolean isEnd = false;

        Node[] nodes = new Node[26];

    }

    public static void main(final String[] args) {
        final String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(new L720_1().longestWord(words));
    }

    public String longestWord(final String[] words) {
        final Node node = new Node();
        // 构建字典树
        for (int i = 0; i < words.length; i++) {
            Node.buildDictionary(node, words[i]);
        }
        final TreeSet<String> result = new TreeSet<String>(new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                else {
                    return o1.compareTo(o2);
                }
            }
        });
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (node.nodes[i] != null) {
                this.longestWord(node.nodes[i], result, builder, (char) (i + 'a'));
            }
        }
        return result.iterator().hasNext() ? result.iterator().next() : null;
    }

    private void longestWord(final Node node, final TreeSet<String> result, final StringBuilder builder, final char c) {
        if (node.isEnd == false) {
            result.add(builder.toString());
            return;
        }
        builder.append(c);
        boolean hasNext = false;
        for (int i = 0; i < 26; i++) {
            if (node.nodes[i] != null) {
                hasNext = true;
                this.longestWord(node.nodes[i], result, builder, (char) (i + 'a'));
            }
        }
        if (!hasNext) {
            result.add(builder.toString());
        }
        builder.deleteCharAt(builder.length() - 1);
    }
}
