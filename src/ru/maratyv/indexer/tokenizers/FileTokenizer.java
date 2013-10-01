package ru.maratyv.indexer.tokenizers;

import ru.maratyv.indexer.Token;
import ru.maratyv.indexer.index.Index;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 6:07 PM
 * Porsche is the only car
 */
public class FileTokenizer implements Tokenizer{

    private BufferedReader bf;

    public FileTokenizer(File inputFile) throws FileNotFoundException {
        bf = new BufferedReader(new FileReader(inputFile));
    }

    public void addTokensTo(Index index) throws IOException {
        String currentLine = bf.readLine();
        int offset = 0;
        try {
            while (currentLine != null) {
                StringBuilder word = new StringBuilder("");
                for (int i = 0; i < currentLine.length(); i++) {
                    char c = currentLine.charAt(i);
                    if (Character.isLetterOrDigit(c)) {
                        word.append(c);
                    } else {
                        if (word.length() != 0) {
                            Token token = new Token(offset + i - word.length(),
                                                    word.toString().toLowerCase());
                            index.add(token);
                            word = new StringBuilder("");
                        }
                    }
                }
                offset += currentLine.length();
                // last word in line
                if (word.length() != 0) {
                    Token token = new Token(offset - word.length(),
                            word.toString());
                    index.add(token);
                }
                currentLine = bf.readLine();
            }
        } finally {
            bf.close();
        }
    }
}
