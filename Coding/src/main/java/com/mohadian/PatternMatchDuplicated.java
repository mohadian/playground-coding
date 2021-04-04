package com.mohadian;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchDuplicated {

    public static void main(String[] args) {
        String text = "hello hello Ab aB";
        Pattern p = Pattern.compile("\\b(\\w+)(\\W+\\1\\b)+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(1));
        }
    }

}
