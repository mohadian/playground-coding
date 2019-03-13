package com.mohadian;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        generate(n, result);

        return result;
    }

    private void generate(int n, List<String> result) {
        if (n <= 1) {
            result.add("()");
            return;
        }
        generate(n - 1, result);

        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < result.size(); i++) {
            tmp.add(result.get(i) + "()");
            tmp.add("()" + result.get(i));
            tmp.add("(" + result.get(i) + ")");
        }
        result.clear();
        result.addAll(tmp);
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        System.out.println(Arrays.toString(generator.generateParenthesis(3).toArray()));
    }
}
