package com.mohadian;

import java.util.HashMap;

public class PasswordCracker {
    public class TrieNode {
        String prefix;
        HashMap<Character, TrieNode> childs = new HashMap();
        boolean isCompleteWord;

        TrieNode(String prefix) {
            this.prefix = prefix;
            this.childs = new HashMap();
        }

        void insert(String st) {
            TrieNode curr = this;
            TrieNode node;

            for (int i = 0; i < st.length(); i++) {
                char ch = st.charAt(i);
                if (curr.childs.containsKey(ch)) {
                    node = curr.childs.get(ch);
                } else {
                    node = new TrieNode(st.substring(0, i + 1));
                    curr.childs.put(ch, node);
                }
                if (st.length() == i + 1) {
                    node.isCompleteWord = true;
                }
                curr = node;
            }
        }

        String check(String s) {
            TrieNode curr = this;
            StringBuilder result = new StringBuilder();
            TrieNode node;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (curr.childs.containsKey(ch)) {
                    node = curr.childs.get(ch);
                } else {
                    return "WRONG PASSWORD";
                }
                if (node.isCompleteWord) {
                    if (i < s.length() - 1) {
                        char nextch = s.charAt(i + 1);
                        if (node.childs.containsKey(nextch)) {
                            curr = node;
                        } else {
                            result.append(" ").append(node.prefix);
                            curr = this;
                        }
                    } else {
                        result.append(" ").append(node.prefix);
                        curr = this;
                    }
                } else {
                    curr = node;
                }
            }

            return result.toString();
        }
    }

    String passwordCracker(String[] pass, String attempt) {
        TrieNode root = new TrieNode("");
        for (int i = 0; i < pass.length; i++) {
            root.insert(pass[i]);
        }

        String crack = root.check(attempt);
        return crack.trim();
    }

    public static void main(String[] args) {
        PasswordCracker psw = new PasswordCracker();
        String result = psw.passwordCracker(new String[]{"we", "web", "adaman", "barcod"}, "webweweb");
        System.out.println(result);
    }
}
