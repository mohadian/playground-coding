package com.mohadian;

public class MasterMind {

    private class Score {
        int hits = 0;
        int semi_hits = 0;

        @Override
        public String toString() {
            return "Hits " + hits + " Semi hits " + semi_hits;
        }
    }

    private Score calculateScore(String solution, String guess) {
        Score score = new Score();

        if (solution.length() == guess.length()) {
            score.hits = calculateHits(solution, guess);
            score.semi_hits = calculateSemiHits(solution, guess);
        }

        return score;
    }

    private int calculateSemiHits(String solution, String guess) {
        int count = 0;
        int[] charcount = new int[5];
        for (int i = 0; i < guess.length(); i++) {
            int code = getCode(guess.charAt(i));
            charcount[code]++;
        }

        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) != guess.charAt(i)) {
                int code = getCode(solution.charAt(i));
                if (charcount[code] > 0) {
                    count++;
                    charcount[code]--;
                }

            }
        }
        return count;
    }

    private int getCode(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
        }
        return 4;
    }

    private int calculateHits(String solution, String guess) {
        int count = 0;
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String solution = "ABCD";
        String guess = "ACDC";

        MasterMind masterMind = new MasterMind();

        Score score = masterMind.calculateScore(solution, guess);

        System.out.println(score);
    }
}
