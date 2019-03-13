package com.mohadian;

import java.util.HashMap;

public class WordFrequencies {

    private static int countFrequencyOneShot(String book, String word) {
        int count = 0;
        String[] words = book.split(" ");
        for (String w : words) {
            if (word.equalsIgnoreCase(w)) {
                count++;
            }
        }
        return count;
    }

    private static HashMap<String, Integer> countFrequencyMultiple(String book) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = book.split(" ");
        for (String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String book = "Wikipedia was launched on January 15, 2001, by Jimmy Wales and Larry Sanger.[10] Sanger coined its name,[11][12] as a portmanteau of wiki [notes 3] and \"encyclopedia\". Initially an English-language encyclopedia, wiki versions in other languages were quickly developed. With 5,767,366 articles,[notes 4] the English Wikipedia is the largest of the more than wiki  290 Wikipedia encyclopedias. Overall, Wikipedia comprises more than 40 million articles in 301 different languages[14] and by February 2014 it had reached 18 billion page views and nearly 500 million unique visitors per month.[15]";
        String word = "Wikipedia";

        int count = countFrequencyOneShot(book, word);
        System.out.println(count);

        HashMap<String, Integer> map = countFrequencyMultiple(book);
        System.out.println(map.getOrDefault(word, 0));
    }
}
