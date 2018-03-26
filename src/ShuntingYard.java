import java.util.*;

public class ShuntingYard {

    private static Map<String, Integer> ops = new HashMap<String, Integer>() {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
    }};

    private static boolean isHigerPrec(String op, String sub) {
        return (ops.containsKey(sub) && ops.get(sub) >= ops.get(op));
    }

    public static String postfix(String infix) {
        StringBuilder output = new StringBuilder();
        Queue<String> varQue = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : infix.split("\\s")) {
            // operator
            if (ops.containsKey(token)) {
                while (!stack.empty() && isHigerPrec(token, stack.peek()))
                    varQue.add(stack.pop());
//                    output.append(stack.pop()).append(' ');
                stack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!stack.peek().equals("("))
                    varQue.add(stack.pop());
//                    output.append(stack.pop()).append(' ');
                stack.pop();

                // digit
            } else {
                varQue.add(token);
//                output.append(token).append(' ');
            }
        }

        while (!stack.isEmpty())
            varQue.add(stack.pop());
//            output.append(stack.pop()).append(' ');

        return output.toString();
    }

    public static void main(String[] args) {
//        StringParser s = new StringParser("2+3*5");
        String s = postfix("( 5.0 + 7i ) * 2");

    }

}