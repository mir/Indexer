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
    private final String docID;
    private final String DELIMITER_PATTERN = "\\W+";

    public FileTokenizer(File inputFile) throws IOException {
        docID = inputFile.getName();
        bf = new BufferedReader(new FileReader(inputFile));
    }

    public void addTokensTo(Index index) throws IOException {
        String currentLine = bf.readLine();
        try {
            while (currentLine != null) {
                Scanner sc = new Scanner(currentLine);
                sc.useDelimiter(DELIMITER_PATTERN);
                while (sc.hasNext()) {
                    Token token = new Token(docID,sc.next().toLowerCase());
                    index.add(token);
                }
                currentLine = bf.readLine();
            }
        } finally {
            bf.close();
        }
    }
}
