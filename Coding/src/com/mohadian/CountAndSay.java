package com.mohadian;

public class CountAndSay {

    private static String countAndSay(int n) {
        String[] s = new String[n + 1];

        s[0] = "1";

        int index = 0;
        while (index < n) {
            char pre = s[index].charAt(0);
            if (s[index + 1] == null) {
                s[index + 1] = "";
            }
            int count = 1;
            for (int i = 1; i < s[index].length(); i++) {
                if (pre == s[index].charAt(i)) {
                    count++;
                } else {
                    s[index + 1] = s[index + 1] + count + pre;
                    count = 1;
                    pre = s[index].charAt(i);
                }
            }
            s[index + 1] = s[index + 1] + count + pre;
            index++;
        }
        return s[index - 1];
    }

    public static void main(String[] args) {
        int n = 6;

        String result = countAndSay(n);

        System.out.println(result);
    }
}
