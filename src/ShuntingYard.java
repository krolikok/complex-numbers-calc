import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShuntingYard {

    private static Map<String, Integer> operators = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 1);
        put("*", 2);
        put("/", 2);
        put("^", 3);
    }};

    private static boolean isRightStrHasHigerPrecedence(String leftStr, String rightStr) {
        return (operators.containsKey(rightStr) && operators.get(rightStr) >= operators.get(leftStr));
    }

    public static String postfix(String infix_string) {
//        Queue<String> varQue = new LinkedList<String>();
        LinkedList<String> varQue = new LinkedList<String>();
        Stack<String> operandStack = new Stack<String>();

        for (String token : infix_string.split("\\s")) {
            // operator
            if (operators.containsKey(token)) {
                while (!operandStack.empty() && isRightStrHasHigerPrecedence(token, operandStack.peek()))
                    varQue.add(operandStack.pop());
                operandStack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                operandStack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!operandStack.peek().equals("("))
                    varQue.add(operandStack.pop());
                operandStack.pop();

                // digit
            } else {
                varQue.add(token);
            }
        }

        while (!operandStack.isEmpty())
            varQue.add(operandStack.pop());

        return varQue.toString().replace(",", "").replace("[", "").replace("]", "");
    }
}