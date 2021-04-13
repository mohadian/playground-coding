package com.mohadian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Autocomplete {

    static class TrieNode {
        String prefix;
        boolean isCompleteWord;
        HashMap<Character, TrieNode> nodes = new HashMap<>();

        TrieNode(String prefix) {
            this.prefix = prefix;
        }

        void insert(String input) {
            TrieNode curr = this;
            int inputLength = input.length();
            for (int i = 0; i < inputLength; i++) {
                TrieNode node;
                char ch = input.charAt(i);
                if (!curr.nodes.containsKey(ch)) {
                    node = new TrieNode(input.substring(0, i) + ch);
                    curr.nodes.put(ch, node);
                } else {
                    node = curr.nodes.get(ch);
                }
                if (inputLength == i + 1) {
                    node.isCompleteWord = true;
                }
                curr = node;
            }
        }

        ArrayList<String> getWords(String prefix, boolean all) {
            TrieNode curr = this;
            ArrayList<String> list = new ArrayList<>();
            TrieNode node = null;

            for (Character c : prefix.toCharArray()) {
                if (curr.nodes.containsKey(c)) {
                    node = curr.nodes.get(c);
                } else {
                    break;
                }
                if (all && node != null && node.isCompleteWord) {
                    list.add(node.prefix);
                }
                curr = node;
            }

            addAllChilds(node, list);

            return list;
        }

        void addAllChilds(TrieNode node, ArrayList<String> results) {
            if (node == null) {
                return;
            }

            for (Character ch : node.nodes.keySet()) {
                TrieNode child = node.nodes.get(ch);
                if (child.isCompleteWord) {
                    results.add(child.prefix);
                }
                addAllChilds(child, results);
            }
        }
    }

    public static void main(String[] args) {
        TrieNode trie = new TrieNode("");

        trie.insert("a");
        trie.insert("ab");
        trie.insert("acghabck");
        trie.insert("abcg");
        trie.insert("abdc");
        trie.insert("abcdc");

        System.out.println(Arrays.toString(trie.getWords("abc", false).toArray()));
        System.out.println(Arrays.toString(trie.getWords("ab", true).toArray()));
    }
}
