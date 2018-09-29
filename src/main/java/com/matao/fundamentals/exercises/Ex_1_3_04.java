package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by matao on 2018/9/29.
 * <p>
 * Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced.
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 */
public class Ex_1_3_04 {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        if (stack.pop() != '(') {
                            return false;
                        }
                    }
                    break;
                case ']':
                    if (!stack.isEmpty()) {
                        if (stack.pop() != '[') {
                            return false;
                        }
                    }
                    break;
                case '}':
                    if (!stack.isEmpty()) {
                        if (stack.pop() != '{') {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        StdOut.print(isBalanced(s));
        s = "[(])";
        StdOut.println(isBalanced(s));
    }
}
