package removeouterparenttheses;

import java.util.Stack;

public class RemoveOuterParentheses {
	public String removeOuterParentheses(String S) {
		StringBuffer stringBuffer = new StringBuffer();
		Stack<Character> stacks = new Stack<Character>();
        int length=S.length();
		for (int i = 0; i < length; i++) {
			Character character=S.charAt(i);
			if (character == '(') {
				if (stacks.size() != 0) {
					stringBuffer.append(character);
				}
				stacks.push('(');
			} else {
				stacks.pop();
				if (stacks.size() != 0) {
					stringBuffer.append(character);
				}
			}
		}
		return stringBuffer.toString();
	}
	
	public String removeOuterParentheses1(String S) {
		
		return "";
	}

}
