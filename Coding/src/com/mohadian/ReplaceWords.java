package com.mohadian;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    private String replaceWords(List<String> dict, String sentence) {
        String result = sentence;

        return result;
    }

    public static void main(String[] args) {
        List<String> dic = new ArrayList<>();
        String sentence = "The cattle was rattled by the battery";

        ReplaceWords replaceWords = new ReplaceWords();

        dic.add("cat");
        dic.add("rat");
        dic.add("rat");

        String result = replaceWords.replaceWords(dic, sentence);

        System.out.println(result);
    }

}
