package pkg202007;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L784 {
	public static void main(String[] args) {
		System.out.println(new L784().letterCasePermutation("c"));
	}

	private void counter(Set<String> result, char[] cs, int i) {
		if (i >= cs.length) {
			return;
		}
		result.add(new String(cs));
		if (cs[i] >= 'a' && cs[i] <= 'z') {
			cs[i] = (char) (cs[i] - 32);
			result.add(new String(cs));
			counter(result, cs, i + 1);
			cs[i] = (char) (cs[i] + 32);
		}

		if (cs[i] >= 'a' && cs[i] <= 'z') {
			cs[i] = (char) (cs[i] + 32);
			result.add(new String(cs));
			counter(result, cs, i + 1);
			cs[i] = (char) (cs[i] - 32);
		}
		counter(result, cs, i + 1);
	}

	public List<String> letterCasePermutation(String S) {
		Set<String> result = new HashSet<>();
		char[] cs = S.toCharArray();
		counter(result, cs, 0);
		return new ArrayList<>(result);
	}

}
