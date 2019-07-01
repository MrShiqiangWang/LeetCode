package package_in_201906;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
	public List<String> fullJustify(String[] words, int maxWidth) {
		int width = 0;
		List<String> result = new ArrayList<>();
		List<String> tmp = new ArrayList<>();
		tmp.add(words[0]);
		width = words[0].length();
		for (int i = 1; i < words.length; i++) {
			if (width + words[i].length() + 1 > maxWidth) {
				// ¹¹Ôì×Ö·û´®
				String string = from(tmp, maxWidth, false);
				result.add(string);
				tmp = new ArrayList<>();
				tmp.add(words[i]);
				width = words[i].length();
			} else {
				tmp.add(words[i]);
				width += words[i].length() + 1;
			}
		}
		String tmpStr = from(tmp, maxWidth, true);
		result.add(tmpStr);
		return result;
	}

	private String from(List<String> tmp, int maxWidth, boolean last) {
		if (last) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < tmp.size(); i++) {
				stringBuffer.append(tmp.get(i));
				if (i != tmp.size() - 1) {
					stringBuffer.append(' ');
				}
			}
			int l = stringBuffer.toString().length();
			for (int i = 0; i < maxWidth - l; i++) {
				stringBuffer.append(' ');
			}
			return stringBuffer.toString();
		}
		if (tmp.size() == 1) {
			int l = tmp.get(0).length();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(tmp.get(0));
			for (int i = 0; i < maxWidth - l; i++) {
				stringBuffer.append(' ');
			}
			return stringBuffer.toString();
		} else {
			int size = 0;
			for (int i = 0; i < tmp.size(); i++) {
				size += tmp.get(i).length();
			}
			int space = (maxWidth - size) / (tmp.size() - 1);
			StringBuffer stringBuffer = new StringBuffer();
			int t = (maxWidth - size) % (tmp.size() - 1);
			for (int i = 0; i < tmp.size() - 1; i++) {
				stringBuffer.append(tmp.get(i));
				for (int j = 0; j < space; j++) {
					stringBuffer.append(' ');
				}
				if (i == 0) {
					for (int j = 0; j < t; j++) {
						stringBuffer.append(' ');
					}
				}
			}
			stringBuffer.append(tmp.get(tmp.size() - 1));
			return stringBuffer.toString();
		}
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(new FullJustify().fullJustify(words, 16));
	}
}
