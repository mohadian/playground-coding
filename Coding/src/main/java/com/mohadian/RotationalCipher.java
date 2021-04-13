package com.mohadian;

public class RotationalCipher {

    static String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch >= '0' && ch<='9'){
                int newChInt = ch - '0';
                newChInt = (newChInt+rotationFactor) % 10;
                ch = (char) ('0' + newChInt);
            }
            if(ch >= 'a' && ch<='z'){
                int newChInt = ch - 'a';
                newChInt = (newChInt+rotationFactor) % 26;
                ch = (char) ('a' + newChInt);
            }
            if(ch >= 'A' && ch<='Z'){
                int newChInt = ch - 'A';
                newChInt = (newChInt+rotationFactor) % 26;
                ch = (char) ('A' + newChInt);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        System.out.println(input_1 + " -> " + output_1 + " " + expected_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        System.out.println(input_2 + " -> " + output_2 + " " + expected_2);
    }
}
