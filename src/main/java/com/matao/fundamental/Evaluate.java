package com.matao.fundamental;

/**
 * Created by matao on 5/27/16.
 * Dijkstra 双栈算数表达式求值算法
 * 1) 将操作数压入操作数栈
 * 2) 将运算符压入运算符栈
 * 3) 忽略左括号
 * 4) 遇到右括号时,弹出一个操作符,弹出所需数量的操作数,二元运算后弹出的操作数在前
 * 并将运算符和操作数的运算结果压入操作数栈
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
