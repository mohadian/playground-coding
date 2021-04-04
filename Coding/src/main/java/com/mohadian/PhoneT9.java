package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneT9 {

    String[] mappings = {
            "", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "0"
    };

    private HashSet<String> wordSet = new HashSet<>();
    private Trie trie = new Trie();

    public PhoneT9() {
        wordSet.add("tree");
        wordSet.add("used");
        wordSet.add("hi");

        trie.insert("tree");
        trie.insert("used");
        trie.insert("hi");
    }

    public ArrayList<String> getSuggestions(String input) {
        ArrayList result = new ArrayList();

        getSuggestionsTrie(input, 0, "", trie, result);
//        getSuggestions(input, 0, "", result);
        return result;
    }

    private void getSuggestions(String input, int index, String prefix, ArrayList result) {
        if (index == input.length() && wordSet.contains(prefix)) {
            result.add(prefix);
            return;
        }

        if (index < input.length()) {
            String options = mappings[input.charAt(index) - '0'];

            for (Character ch : options.toCharArray()) {
                getSuggestions(input, index + 1, prefix + ch, result);
            }
        }
    }

    private void getSuggestionsTrie(String input, int index, String prefix, Trie trie, ArrayList result) {
        if (index == input.length()) {
            if (trie.contains(prefix)) {
                result.add(prefix);
            }
            return;
        }

        if (index < input.length()) {
            String options = mappings[input.charAt(index) - '0'];

            for (Character ch : options.toCharArray()) {
                if (trie.contains(prefix + ch)) {
                    getSuggestions(input, index + 1, prefix + ch, result);
                }
            }
        }
    }

    private class Trie {
        TrieNode root;

        class TrieNode {
            Character data;
            boolean terminal;
            HashMap<Character, TrieNode> children;

            TrieNode() {
                children = new HashMap<>();
            }

            void insert(String s, int index) {
                data = s.charAt(index);
                if (s.length() == index + 1) {
                    terminal = true;
                } else {
                    TrieNode node = new TrieNode();
                    children.put(data, node);
                    node.insert(s, index + 1);
                }
            }

            boolean contains(String q, int index) {
                if (q.length() == index + 1) {
                    return true;
                } else {
                    TrieNode node = children.get(q.charAt(index));
                    if (node != null) {
                        return node.contains(q, index + 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        void insert(String s) {
            if (root == null) {
                root = new TrieNode();
            }
            root.insert(s, 0);
        }

        boolean contains(String s) {
            if (root == null) {
                root = new TrieNode();
            }
            return root.contains(s, 0);
        }

    }

    public static void main(String[] args) {
        String input = "8733";

        ArrayList list;
        PhoneT9 t9 = new PhoneT9();

        list = t9.getSuggestions(input);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
