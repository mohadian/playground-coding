package com.mohadian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTrie {
    static class Trie {
        TrieNode root = new TrieNode();


        static class TrieNode {
            boolean isTerminal;
            int count;
            Map<Character, TrieNode> children;

            void insert(String str, int index) {
                if (str.length() == index) {
                    isTerminal = true;
                    count = 1;
                } else {
                    if (children == null) {
                        children = new HashMap();
                    }
                    char ch = str.charAt(index);
                    if (!children.containsKey(ch)) {
                        children.put(ch, new TrieNode());
                    }
                    count++;
                    children.get(ch).insert(str, index + 1);
                }
            }

            int findOccurrence(String str, int index) {
                if (str.length() == index) {
                    return count;
                } else {
                    if (children == null) {
                        return 0;
                    }
                    char ch = str.charAt(index);
                    if (children.containsKey(ch)) {
                        return children.get(ch).findOccurrence(str, index + 1);
                    } else {
                        return 0;
                    }
                }
            }
        }

        void insert(String str) {
            root.insert(str, 0);
        }

        int findOccurrence(String str) {
            return root.findOccurrence(str, 0);
        }
    }

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        Trie trie = new Trie();
        List<Integer> list = new ArrayList();
        int i;
        for (i = 0; i < queries.length; i++) {
            if (queries[i][0].equalsIgnoreCase("insert")) {
                trie.insert(queries[i][1]);
            } else if (queries[i][0].equalsIgnoreCase("find")) {
                list.add(trie.findOccurrence(queries[i][1]));
            }
        }

        int[] result = new int[list.size()];

        i = 0;
        for (Integer item : list) {
            result[i++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] queries = {{"insert", "s"}, {"insert", "ss"}, {"insert", "sss"}, {"insert", "ssss"}, {"insert", "sssss"},
                {"find", "s"}, {"find", "ss"}, {"find", "sss"}, {"find", "ssss"}, {"find", "sssss"}};
        System.out.println(contacts(queries).toString());
    }

}
