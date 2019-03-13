package com.mohadian;

import java.util.Stack;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 * Implement a function 'int eval(String expr)' that evaluates expressions matching this syntax:
 * <p>
 * expr ::= int | '(' op expr+ ')'
 * op ::= '+' | '*'
 * <p>
 * Examples:
 * "3" -> 3
 * "( + 1 2 )" -> 1 + 2 -> 3
 * "( + 3 4 5 )" -> 12
 * “( + (* 3 4 ) ( + 1 1) 3)” -> 17
 */

public class EvalExpr {

    private static int evaluate(String exp) {
        Stack<String> operators = new Stack();
        Stack<String> operands = new Stack();

        String token;
        String[] tokens = getTokens(exp);
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (isOperator(token)) {
                operators.push(token);
            } else if (isOpenBracket(token)) {
                operands.push(token); //”(”
            } else if (isCloseBracket(token)) { // “)”
                int val = getIntVal(operands.pop());
                String op = operators.pop();
                while (isNumber(operands.peek())) {
                    int operand = getIntVal(operands.pop());
                    if ("+".equals(op)) {
                        val += operand;
                    }
                    if ("*".equals(op)) {
                        val *= operand;
                    }
                }
                operands.pop();
                operands.push("" + val);
            } else {
                operands.push(token);
            }
        }
        return getIntVal(operands.pop());

    }

    private static boolean isCloseBracket(String token) {
        return ")".equals(token);
    }

    private static boolean isOpenBracket(String token) {
        return "(".equals(token);
    }

    private static int getIntVal(String str) {
        return Integer.valueOf(str);
    }

    private static String[] getTokens(String exp) {
        return exp.split(" ");
    }

    private static boolean isOperator(String token) {
        return "+".equals(token) || "*".equals(token);
    }

    public static void main(String[] args) {
        String exp = "( + ( * 3 4 ) ( + 1 1 ) 3 )";

        int val = evaluate(exp);
        System.out.println(val);
    }
}
