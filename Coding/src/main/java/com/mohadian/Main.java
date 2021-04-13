package com.mohadian;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
        Scanner sc = new Scanner(url.openStream());

        HashMap<String, ArrayList> dict = new HashMap<>();

        while (sc.hasNext()) {
            String word = sc.next();
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sorted = new String(wordChars);
            if(!dict.containsKey(sorted)){
                dict.put(sorted, new ArrayList<String>());
            }
            dict.get(sorted).add(word);
        }
        sc.close();
    }
}

