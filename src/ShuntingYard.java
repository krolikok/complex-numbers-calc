import java.util.*;

public class ShuntingYard {

    private static Map<String, Integer> operators = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
    }};

    private static boolean isRightStrHigerPrec(String leftStr, String rightStr) {
        return (operators.containsKey(rightStr) && operators.get(rightStr) >= operators.get(leftStr));
    }

    public static void postfix(String infix) {
        Queue<String> varQue = new LinkedList<String>();
        Stack<String> operStack = new Stack<String>();

        for (String token : infix.split("\\s")) {
            // operator
            if (operators.containsKey(token)) {
                while (!operStack.empty() && isRightStrHigerPrec(token, operStack.peek()))
                    varQue.add(operStack.pop());
                operStack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                operStack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!operStack.peek().equals("("))
                    varQue.add(operStack.pop());
                operStack.pop();

                // digit
            } else {
                varQue.add(token);
            }
        }

        while (!operStack.isEmpty())
            varQue.add(operStack.pop());

//        return varQue;
    }

    public static void main(String[] args) {
//        StringParser s = new StringParser("2+3*5");
        postfix("( 5.0 + 7i ) * 2");

    }

}