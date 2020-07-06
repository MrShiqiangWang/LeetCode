package history.pkg201907;

import java.util.Stack;

public class LengthLongestPath {

    public static void main(final String[] args) {
        System.out.println(new LengthLongestPath().lengthLongestPath(
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

        // System.out.println("\t".length());
    }

    public int lengthLongestPath(final String input) {
        final String[] subStrs = input.split("\n");
        final Stack<String> stack = new Stack<>();
        int level = -1;
        int max = 0;
        int currentSize = 0;
        for (int i = 0; i < subStrs.length; i++) {
            // ͳ�Ƶ�ǰ�ַ�����\t��Ŀ s
            final int count = this.findTNumber(subStrs[i]);
            // ���\t����Ŀ����level,��ջ s>level
            // ��¼ջ���ַ�����
            // ȡ����ַ�����
            if (count > level) {
                level++;
                stack.push(subStrs[i]);
                currentSize = currentSize + (subStrs[i].length() - count);
                // �����ǰ���ַ����Ǹ��ļ�����ͳ�Ƴ���
                // �жϵ�ǰ�ַ���Ϊ�ļ�
                if (this.isFile(subStrs[i])) {
                    max = Math.max(max, currentSize + level);
                }
            }
            else {
                // ���С�ڵ���level������level-s+1��
                // ��¼ջ���ַ�����
                // ȡ����ַ�����
                final int popCounter = level - count + 1;
                // ��ʼ����
                for (int j = 0; j < popCounter; j++) {
                    final String string = stack.pop();
                    currentSize = currentSize - (string.length() - level);
                    level--;
                }
                level++;
                stack.push(subStrs[i]);
                currentSize = currentSize + (subStrs[i].length() - count);
                if (this.isFile(subStrs[i])) {
                    max = Math.max(max, currentSize + level);
                }
            }

        }
        return max;
    }

    private int findTNumber(final String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) != '\t') {
                break;
            }
            sum++;
        }
        return sum;
    }

    private boolean isFile(final String name) {
        final int index = name.indexOf('.');
        if (index != -1 && index != name.length() - 1) {
            return true;
        }
        return false;
    }
}
