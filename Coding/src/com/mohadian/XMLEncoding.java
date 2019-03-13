package com.mohadian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XMLEncoding {
    HashMap<String, Integer> codes;

    class Token {
        String value;
        int code;
        boolean tag;
    }

    public XMLEncoding() {
        codes = new HashMap<>();
        codes.put("family", 1);
        codes.put("lastname", 2);
        codes.put("state", 3);
    }

    private String encode(String xml) {
        List<Token> tokens = readTokens(xml);
        StringBuffer sb = new StringBuffer();

        for (Token token : tokens) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (token.tag) {
                sb.append(token.code);
            } else {
                sb.append(token.value);
            }
        }

        return sb.toString();
    }

    private List<Token> readTokens(String xml) {
        ArrayList<Token> tokens = new ArrayList<>();

        if(xml.startsWith("<")){
            String substring = xml.substring(0, xml.indexOf('>'));
            String[] att = substring.split(" ");
            tokens.add(readFirstToken(att));
            tokens.addAll(readAttributes(att));
            tokens.add(lastToken());
        }
        return tokens;
    }

    private ArrayList<Token> readAttributes(String[] att) {
        ArrayList<Token> tokens = new ArrayList<>();
        for (int i = 1; i < att.length; i++) {
            String[] parts = att[i].split("=");
            Token token = new Token();
            token.value = parts[0];
            token.code = codes.get(token.value);
            token.tag = true;

            tokens.add(token);

            token = new Token();
            token.value = parts[1];
            token.code = -1;
            token.tag = false;

            tokens.add(token);
        }

        return tokens;
    }

    private Token lastToken() {
        Token token = new Token();
        token.value = "END";
        token.code = 0;
        token.tag = true;
        return token;
    }

    private Token readFirstToken(String[] att) {
        Token token = new Token();
        String tag = att[0];
        token.value = tag.substring(1);
        token.code = codes.get(token.value);
        token.tag = true;
        return token;
    }

    public static void main(String[] args) {
        String xml = "<family lastname=\"Hadian\" state=\"UK\">";

        XMLEncoding xmlEncoding = new XMLEncoding();
        String encoded = xmlEncoding.encode(xml);

        System.out.println(encoded);
    }
}
