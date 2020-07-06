package history.pkg201907;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParseBoolExpr {

    public static void main(final String[] args) {
        System.out.println(new ParseBoolExpr().parseBoolExpr("!(&(!(t),&(f),|(f)))"));
    }

    Stack<Character> stack = new Stack<>();

    public boolean parseBoolExpr(final String expression) {
        final char[] characters = expression.toCharArray();
        boolean total = true;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ',') {
                continue;
            }
            else if (characters[i] == ')') {
                // ����
                // ������������Ϊֹ
                final List<Boolean> result = new ArrayList<>();
                Character tmp = this.stack.pop();
                while (tmp != '(') {
                    if (tmp == 't') {
                        result.add(true);
                    }
                    else {
                        result.add(false);
                    }
                    tmp = this.stack.pop();
                }

                tmp = this.stack.pop();
                if (tmp == '!') {
                    final Boolean boolean1 = result.get(0);
                    total = (!boolean1);
                }
                else if (tmp == '|') {
                    Boolean boolean1 = result.get(0);
                    for (int j = 1; j < result.size(); j++) {
                        boolean1 |= result.get(j);
                    }
                    total = boolean1;
                }
                else {
                    Boolean boolean1 = result.get(0);
                    for (int j = 0; j < result.size(); j++) {
                        boolean1 &= result.get(j);
                    }
                    total = boolean1;
                }

                if (total == true) {
                    this.stack.push('t');
                }
                else {
                    this.stack.push('f');
                }

                System.out.println(this.stack.toString());
                // �ٵ���һ������
            }
            else {
                this.stack.push(characters[i]);
            }

        }
        return total;
    }
}
