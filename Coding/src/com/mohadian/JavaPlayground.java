package com.mohadian;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPlayground {

    private static String cipher(String input, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char ch = (char) ('A'+ ((input.charAt(i)-'A')+n)%26);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main (String[] args )
    {
        String str = "On_the_edge_of_history";
        String[] tmp = str.split("_");
        System.out.println( Arrays.toString(tmp));
        System.out.println( );

        str = "On_the___edge_of____history";
        tmp = str.split("_+");
        System.out.println( Arrays.toString(tmp));
        System.out.println( );

        str = "On***the___edge**of____history";
        tmp = str.split("_+|\\*+");
        System.out.println( Arrays.toString(tmp));
        System.out.println( );

        String in = "asdfghaUIqw";
        Pattern pattern = Pattern.compile("A|E|I|O|U|a|e|i|o|u");
        Matcher matcher = pattern.matcher(in);
        int count = 0;
        while(matcher.find()) count++;
        System.out.println(count);

        String input = "ABCZ";
        System.out.println(cipher(input, 26));
    }
}
