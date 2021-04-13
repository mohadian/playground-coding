package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneLetterCombination {

    private List<String> letterCombination(String input) {
        List<String> result = new ArrayList<>();
        if(input == null || input.isEmpty()){
            return result;
        }

        String[] mappings = {
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"
        };

        letterCombinationRecursive(input, result, "", 0, mappings);
        //letterCombinationIterative(input, result,  mappings);
        return result;
    }

    private void letterCombinationRecursive(String input, List<String> result, String current, int index, String[] mappings) {
        if(index >= input.length()){
            result.add(current);
            return;
        }

        String letters = mappings[input.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationRecursive(input, result, current+letters.charAt(i), index+1, mappings);
        }
    }

    private void letterCombinationIterative(String input, List<String> result, String[] mappings) {
        List<String> temp = new ArrayList<>();
        result.add("");

        for (int i = 0; i < input.length(); i++) {
            String letters = mappings[input.charAt(i) - '0'];
            temp.clear();
            temp.addAll(result);
            result.clear();
            for (int j = 0; j < letters.length(); j++) {
                for (String st: temp) {
                    result.add(st+letters.charAt(j));
                }
            }
        }
    }

    public static void main(String[] args) {
        PhoneLetterCombination combination = new PhoneLetterCombination();
        List<String> result = combination.letterCombination("42");
        System.out.println(Arrays.toString(result.toArray()));
        result = combination.letterCombination("23");
        System.out.println(Arrays.toString(result.toArray()));
    }
}
