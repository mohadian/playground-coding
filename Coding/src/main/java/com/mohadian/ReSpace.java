package com.mohadian;

import java.util.HashSet;

public class ReSpace {

    private HashSet<String> dictionary;

    public ReSpace(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }

    static class ParsedResult {
        String parsed;
        int invalidCount;

        public ParsedResult(String parsed, int nonValidCount) {
            this.parsed = parsed;
            this.invalidCount = nonValidCount;
        }

        @Override
        public String toString() {
            return "ParsedResult{" +
                    "parsed= '" + parsed + '\'' +
                    ", invalidCount= " + invalidCount +
                    '}';
        }
    }

    private ParsedResult split(String sentence) {
        return split(sentence, 0);
    }

    private ParsedResult split(String sentence, int start) {
        if (start >= sentence.length()) {
            return new ParsedResult("", 0);
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsed = "";
        String partial = "";

        int index = start;

        while (index < sentence.length()) {
            char ch = sentence.charAt(index);
            partial += ch;
            int invalid = (dictionary.contains(partial)) ? 0 : partial.length();
            if (invalid < bestInvalid) {
                ParsedResult partailResult = split(sentence, index + 1);
                if (invalid + partailResult.invalidCount < bestInvalid) {
                    bestInvalid = invalid + partailResult.invalidCount;
                    bestParsed = partial + " " + partailResult.parsed;
                    if (bestInvalid == 0) break;
                }
            }
            index++;
        }

        return new ParsedResult(bestParsed, bestInvalid);
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("I");
        dictionary.add("set");
        dictionary.add("reset");
        dictionary.add("the");
        dictionary.add("computer");

        String sentence = "Ireset";

        ReSpace reSpace = new ReSpace(dictionary);
        ParsedResult output = reSpace.split(sentence);
        System.out.println(output);
    }
}
