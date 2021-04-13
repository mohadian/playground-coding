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

    public static String countAndSay2(int n) {
        String num = "1";

        for (int i=1; i<n; i++){
            num = countAndSayNum2(num);
        }
        return num;
    }

    private static String countAndSayNum2(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++){
            if(ch != s.charAt(i)){
                sb.append(count);
                sb.append(ch);
                ch = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 6;

        String result = countAndSay(n);
        String result2 = countAndSay2(n);

        System.out.println(result);
        System.out.println(result2);
    }
}
