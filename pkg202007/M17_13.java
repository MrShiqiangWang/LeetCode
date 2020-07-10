package pkg202007;

public class M17_13 {

    private static class Tribe {

        public static Tribe buildTribe(final String[] dictionary) {
            final Tribe tribe = new Tribe();
            for (int i = 0; i < dictionary.length; i++) {
                buildTribe(tribe, dictionary[i]);
            }
            return tribe;
        }

        public static void buildTribe(Tribe tribe, final String vocabulary) {
            final char[] chars = vocabulary.toCharArray();
            Tribe tribe2 = null;
            for (int i = 0; i < chars.length; i++) {
                final char c = chars[i];
                if (tribe.tribes[(c) - 97] != null) {
                    tribe2 = tribe.tribes[(c) - 97];
                }
                else {
                    tribe2 = new Tribe();
                    tribe.tribes[(c) - 97] = tribe2;
                }
                tribe = tribe2;
            }
            tribe2.isEnd = true;
        }

        // 26个后续
        Tribe[] tribes = new Tribe[26];

        // 字典表的末尾
        boolean isEnd = false;
    }

    /**
     * ["looked","just","like","her","brother"]
     * "jesslookedjustliketimherbrother"
     *
     * @param args
     */

    public static void main(final String[] args) {
        // []
        // "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr"
        final String[] dictionary2 = {
                "vprkj",
                "sqvuzjz",
                "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp",
                "spqzqtrqs",
                "rkktkruzsjkrzqq",
                "rk",
                "k",
                "zkvdzqrzpkrukdqrqjzkrqrzzkkrr",
                "pzpstvqzrzprqkkkd",
                "jvutvjtktqvvdkzujkq",
                "r",
                "pspkr",
                "tdkkktdsrkzpzpuzvszzzzdjj",
                "zk",
                "pqkjkzpvdpktzskdkvzjkkj",
                "sr",
                "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu" };
        System.out.println(new M17_13().respace(
                dictionary2,
                "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr"));
    }

    public int respace(final String[] dictionary, final String sentence) {
        final Tribe tribe = Tribe.buildTribe(dictionary);
        return this.respace(tribe, sentence);
    }

    private int respace(final Tribe tribe, final String sentence) {
        final char[] cs = sentence.toCharArray();
        int max = Integer.MAX_VALUE;
        int sum = 0;
        int counter = 0;
        Tribe tmpTribe = tribe;
        for (int i = 0; i < cs.length; i++) {
            // System.out.println(cs[i]);
            if (tmpTribe.tribes[cs[i] - 97] == null && tmpTribe.isEnd == false) {
                // 未识别字符
                counter++;
                sum++;
                // 移动指针到
                i = i - counter + 1;
                counter = 0;
                tmpTribe = tribe;
            }
            else if (tmpTribe.tribes[cs[i] - 97] == null && tmpTribe.isEnd == true) {
                counter = 0;
                i--;
                tmpTribe = tribe;
            }
            else if (tmpTribe.tribes[cs[i] - 97] != null && tmpTribe.isEnd == true) {

                // 可以继续下去
                tmpTribe = tmpTribe.tribes[cs[i] - 97];
                counter++;
                // 也可以直接结束,从头开始
                final int remainSum = this.respace(tribe, sentence.substring(i - counter + 2, cs.length));
                max = Math.min(max, remainSum + sum);
            }
            else {// tribe.tribes[(int) cs[i] - 97] != null && tribe.isEnd ==
                  // false
                tmpTribe = tmpTribe.tribes[cs[i] - 97];
                counter++;
                if (i == cs.length - 1 && !tmpTribe.isEnd) {
                    sum++;
                }
            }
        }
        return Math.min(sum, max);
    }
}
