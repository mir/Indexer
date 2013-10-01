package ru.maratyv.indexer;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 6:07 PM
 * Porsche is the only car
 */
public class FileTokenizer {

    private BufferedReader bf;
    private StringTokenizer stringTokenizer;

    public FileTokenizer(File inputFile) throws FileNotFoundException {
        stringTokenizer = new PatternStringTokenizer();
        initialize(inputFile);
    }

    public FileTokenizer(File inputFile, StringTokenizer stringTokenizer) throws FileNotFoundException {
        this.stringTokenizer = stringTokenizer;
        initialize(inputFile);
    }

    private void initialize(File inputFile) throws FileNotFoundException {
        bf = new BufferedReader(new FileReader(inputFile));
    }

    public void tokenizeTo(File outputFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        String currentLine = bf.readLine();
        try {
            while (currentLine != null) {
                bw.append(stringTokenizer.tokenizeString(currentLine));
                currentLine = bf.readLine();
            }
        } finally {
            bw.close();
            bf.close();
        }
    }
}
