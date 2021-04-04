package com.mohadian;

import java.util.Stack;

public class InfixCalculator {
    Stack<String> operator = new Stack<>();
    Stack<Float> operand = new Stack<>();

    public InfixCalculator() {

    }

    float calculate(String expr) {
        float result = 0.0f;

        String[] tokens = getTokens(expr);

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                while (!operator.isEmpty() && (samePriority(operator.peek(), token) || higherPriority(operator.peek(), token))) {
                    float val1 = operand.pop();
                    float val2 = operand.pop();
                    float res = apply(val2, operator.pop(), val1);
                    operand.push(res);
                }
                operator.push(token);
            } else {
                operand.push(Float.parseFloat(token));
            }
        }

        while (!operator.isEmpty()) {
            float val1 = operand.pop();
            float val2 = operand.pop();
            float res = apply(val2, operator.pop(), val1);
            operand.push(res);
        }

        return (!operand.isEmpty()) ? operand.pop() : result;
    }

    private boolean higherPriority(String op, String token) {
        if (op.equalsIgnoreCase("*") || op.equalsIgnoreCase("/")) {
            return (token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-"));
        }
        return false;
    }

    private float apply(float val1, String pop, float val2) {
        if (pop.equalsIgnoreCase("+")) {
            return val1 + val2;
        }
        if (pop.equalsIgnoreCase("-")) {
            return val1 - val2;
        }
        if (pop.equalsIgnoreCase("*")) {
            return val1 * val2;
        }
        if (pop.equalsIgnoreCase("/")) {
            return val1 / val2;
        }
        return 0.0f;
    }

    private boolean samePriority(String op, String token) {
        if (op.equalsIgnoreCase("+") || op.equalsIgnoreCase("-")) {
            return (token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-"));
        }
        return (token.equalsIgnoreCase("*") || token.equalsIgnoreCase("/"));
    }

    private boolean isOperator(String op) {
        return op.equalsIgnoreCase("+") || op.equalsIgnoreCase("-") || op.equalsIgnoreCase("*") || op.equalsIgnoreCase("/");
    }

    private String[] getTokens(String expr) {
        return expr.split(" ");
    }

    public static void main(String[] args) {
        String expr = "4 + 5 - 3 * 2 * 4";

        InfixCalculator calculator = new InfixCalculator();

        float result = calculator.calculate(expr);
        System.out.println(result);
    }
}
