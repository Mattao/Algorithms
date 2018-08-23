package com.matao.fundamentals;

/**
 * Created by matao on 5/27/16.
 * <p>
 * Dijkstra’s Two-Stack Algorithm for Expression Evaluation
 * 1) Push operands onto the operand stack.
 * 2) Push operators onto the operator stack.
 * 3) Ignore left parentheses.
 * 4) On encountering a right parenthesis, pop an operator, pop the requisite number of operands,
 *    and push onto the operand stack the result of applying that operator to those operands.
 */
public class Evaluate {

    public static double evaluate(String exp) {
        Stack<String> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (String s : exp.split(" ")) {
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operators.push(s);
                    break;
                case ")":
                    String operator = operators.pop();
                    double value = values.pop();
                    switch (operator) {
                        case "+":
                            values.push(values.pop() + value);
                            break;
                        case "-":
                            values.push(values.pop() - value);
                            break;
                        case "*":
                            values.push(values.pop() * value);
                            break;
                        case "/":
                            values.push(values.pop() / value);
                            break;
                        case "sqrt":
                            values.push(Math.sqrt(value));
                            break;
                        default:
                            break;
                    }
                    break;
                default:    // number
                    values.push(Double.parseDouble(s));
                    break;
            }
        }
        return values.pop();
    }


    public static void main(String[] args) {
        String exp1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";     // expected 101.0
        System.out.println(evaluate(exp1));

        String exp2 = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";     // expected 101
        System.out.println(evaluate(exp2));

    }
}
