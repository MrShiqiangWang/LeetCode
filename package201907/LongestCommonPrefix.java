package package201907;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 遍历每个字符串
        for (int i = 1; i < strs.length; i++) {
            // 对于每个字符串进行前n个数据的比较
            char[] prefixChar = prefix.toCharArray();
            char[] strChar = strs[i].toCharArray();

            int index = 0;
            // 找到第一个不相等的数据
            while (index < prefixChar.length && index < strChar.length && prefixChar[index] == strChar[index]) {
                index++;
            }

            // 找到了不相等的数据
            prefix = prefix.substring(0, index);
        }
        return prefix;
    }
}
