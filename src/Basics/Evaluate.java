package Basics;

import java.util.Stack;

/**
 * Created by matao on 5/27/16.
 * Dijkstra 双栈算数表达式求值算法
 * 1) 将操作数压入操作数栈
 * 2) 将运算符压入运算符栈
 * 3) 忽略左括号
 * 4) 遇到右括号时,弹出一个操作符,弹出所需数量的操作数,并将运算符和操作数的运算结果压入操作数栈
 */
public class Evaluate {
    public static void main(String[] args) {
        String exp = "(1+((2+3)*(4*5)))";     // expected 101

        Stack<Character> operations = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '(':
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    operations.push(c);
                    break;
                case ')':
                    char op = operations.pop();
                    double val1 = values.pop();
                    double val2 = values.pop();
                    switch (op) {
                        case '+':
                            values.push(val2 + val1);
                            break;
                        case '-':
                            values.push(val2 - val1);
                            break;
                        case '*':
                            values.push(val2 * val1);
                            break;
                        case '/':
                            values.push(val2 / val1);
                            break;
                    }
                    break;
                default:
                    values.push(Double.parseDouble(c + ""));
                    break;
            }
        }
        System.out.println(values.pop());
    }
}
