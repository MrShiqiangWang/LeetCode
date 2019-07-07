package package_in_201907;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LengthLongestPath {

	public static void main(String[] args) {
		System.out.println(new LengthLongestPath().lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

		// System.out.println("\t".length());
	}

	public int lengthLongestPath(String input) {
		String[] subStrs = input.split("\n");
		Stack<String> stack = new Stack<>();
		int level = -1;
		int max = 0;
		int currentSize = 0;
		for (int i = 0; i < subStrs.length; i++) {
			// 统计当前字符串的\t数目 s
			int count = findTNumber(subStrs[i]);
			// 如果\t的数目大于level,入栈 s>level
			// 记录栈的字符长度
			// 取最大字符长度
			if (count > level) {
				level++;
				stack.push(subStrs[i]);
				currentSize = currentSize + (subStrs[i].length() - count);
				// 如果当前的字符串是个文件，则统计长度
				// 判断当前字符串为文件
				if (isFile(subStrs[i])) {
					max = Math.max(max, currentSize + level);
				}
			} else {
				// 如果小于等于level，弹出level-s+1个
				// 记录栈的字符长度
				// 取最大字符长度
				int popCounter = level - count + 1;
				// 开始弹出
				for (int j = 0; j < popCounter; j++) {
					String string = stack.pop();
					currentSize = currentSize - (string.length() - level);
					level--;
				}
				level++;
				stack.push(subStrs[i]);
				currentSize = currentSize + (subStrs[i].length() - count);
				if (isFile(subStrs[i])) {
					max = Math.max(max, currentSize + level);
				}
			}

		}
		return max;
	}

	private boolean isFile(String name) {
		int index = name.indexOf('.');
		if (index != -1 && index != name.length() - 1) {
			return true;
		}
		return false;
	}

	private int findTNumber(String value) {
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != '\t') {
				break;
			}
			sum++;
		}
		return sum;
	}
}
