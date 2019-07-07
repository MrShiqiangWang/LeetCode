package package_in_201907;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParseBoolExpr {

	public static void main(String[] args) {
		System.out.println(new ParseBoolExpr().parseBoolExpr("!(&(!(t),&(f),|(f)))"));
	}

	Stack<Character> stack = new Stack<>();

	public boolean parseBoolExpr(String expression) {
		char[] characters = expression.toCharArray();
		boolean total = true;
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == ',') {
				continue;
			} else if (characters[i] == ')') {
				// 弹出
				// 弹出到左括号为止
				List<Boolean> result = new ArrayList<>();
				Character tmp = stack.pop();
				while (tmp != '(') {
					if (tmp == 't') {
						result.add(true);
					} else {
						result.add(false);
					}
					tmp = stack.pop();
				}

				tmp = stack.pop();
				if (tmp == '!') {
					Boolean boolean1 = result.get(0);
					total = (!boolean1);
				} else if (tmp == '|') {
					Boolean boolean1 = result.get(0);
					for (int j = 1; j < result.size(); j++) {
						boolean1 |= result.get(j);
					}
					total = boolean1;
				} else {
					Boolean boolean1 = result.get(0);
					for (int j = 0; j < result.size(); j++) {
						boolean1 &= result.get(j);
					}
					total = boolean1;
				}

				if (total == true) {
					stack.push('t');
				} else {
					stack.push('f');
				}

				System.out.println(stack.toString());
				// 再弹出一个符号
			} else {
				stack.push(characters[i]);
			}

		}
		return total;
	}
}
