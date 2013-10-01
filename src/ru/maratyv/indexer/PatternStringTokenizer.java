package ru.maratyv.indexer;

import java.util.Scanner;

public class PatternStringTokenizer implements StringTokenizer {

    private static final String WORD_PATTERN = "\\w+";
    private static final String TOKENS_DELIMITER = " ";

    private Scanner sc;

    public PatternStringTokenizer(String inputString) {
        sc = new Scanner(inputString);
    }

    public String tokenizeString() {
        StringBuilder sb = new StringBuilder("");
        while (sc.hasNext()) {
            if (sc.hasNext(WORD_PATTERN)) {
                String word = sc.next(WORD_PATTERN);
                sb.append(word.toLowerCase());
                sb.append(TOKENS_DELIMITER);
            } else {
                sc.next();
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    @Override
    public String nextToken() {
        while (sc.hasNext()) {
            if (sc.hasNext(WORD_PATTERN)) {
                return sc.next(WORD_PATTERN).toLowerCase();
            } else {
                sc.next();
            }
        }
        return null;
    }

    @Override
    public boolean hasNextToken() {
        while (sc.hasNext()) {
            if (sc.hasNext(WORD_PATTERN)) {
                return true;
            } else {
                sc.next();
            }
        }
        return false;
    }
}