package com.mohadian;

class WordDictionary {

    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        root.insert(word, 0);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return root.find(word, 0);
    }

    class TrieNode {
        boolean terminal;
        TrieNode[] children = new TrieNode[26];

        void insert(String str, int i) {
            if (str.length() == i) {
                terminal = true;
            } else {
                char ch = str.charAt(i);
                if(children[ch - 'a'] == null) {
                    children[ch - 'a'] = new TrieNode();
                }
                children[ch - 'a'].insert(str, i + 1);
            }
        }

        boolean find(String word, int i) {
            if (i == word.length()) {
                return terminal;
            } else {
                char ch = word.charAt(i);
                if (ch == '.') {
                    boolean child = false;
                    for (int j = 0; j < children.length; j++) {
                        if (children[j] != null)
                            child |= children[j].find(word, i + 1);
                    }
                    return child ;
                } else {
                    TrieNode node = children[ch - 'a'];
                    if (node == null) {
                        return false;
                    } else {
                        return node.find(word, i + 1);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("a");
        obj.addWord("ab");
        System.out.println(obj.search("a"));
    }
}
