import java.util.Locale;
import java.util.Stack;

public class CalcEngine {


    private String infix_str, postfix_str;
    private ComplexNumber result;


    public CalcEngine(String infix_str) {
        this.infix_str = infix_str;
        this.postfix_str = ShuntingYard.postfix(infix_str);
        this.result = this.evaluateExpression();
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str.replace("i", ""));
            return true;
        } catch (NumberFormatException nfe) {
            return str.equals("i");
        }

    }

    private ComplexNumber evaluateExpression() {
        Stack<ComplexNumber> tmpEvaluationStack = new Stack<ComplexNumber>();

        for (String token : this.postfix_str.split("\\s")) {
            if (isNumeric(token)) {
                if (token.contains("i")) {
                    if (token.equals("i"))
                        tmpEvaluationStack.push(new ComplexNumber(0, 1));
                    else
                        tmpEvaluationStack.push(new ComplexNumber(0, Double.parseDouble(token.replace("i", ""))));
                } else
                    tmpEvaluationStack.push(new ComplexNumber(Double.parseDouble(token), 0));
            } else {
                ComplexNumber b = tmpEvaluationStack.pop();
                ComplexNumber a = tmpEvaluationStack.pop();
                if (token.contains("+"))
                    tmpEvaluationStack.push(ComplexNumber.add(a, b));
                else if (token.contains("-"))
                    tmpEvaluationStack.push(ComplexNumber.substract(a, b));
                else if (token.contains("*"))
                    tmpEvaluationStack.push(ComplexNumber.multiply(a, b));
                else if (token.contains("/"))
                    tmpEvaluationStack.push(ComplexNumber.divide(a, b));
                else if (token.contains("^"))
                    tmpEvaluationStack.push(ComplexNumber.pow(a, b));
                else
                    System.out.println("ERROR!");
            }

        }
        ComplexNumber result = tmpEvaluationStack.pop();
        return result;
    }

    public String getNormalStringResult() {
        return String.format(Locale.US, "%f + %fi", this.result.getReal(), this.result.getImag());
    }

    public String getTrygStringResult() {
        return String.format(Locale.US, "%f < %f", this.result.getMagnitude(), this.result.getArg() * 180 / Math.PI);
    }


//    public String to_string()
}
