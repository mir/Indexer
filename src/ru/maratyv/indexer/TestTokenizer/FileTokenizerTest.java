package ru.maratyv.indexer.TestTokenizer;

import junit.framework.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.FileTokenizer;
import ru.maratyv.indexer.PatternStringTokenizer;

import java.io.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 6:11 PM
 * Porsche is the only car
 */
@RunWith(JUnit4.class)
public class FileTokenizerTest {
    public static final File LOREM_FILE = new File("test_input.txt");
    public static final File TEMP_OUTPUT_FILE = new File("temp.txt");
    public static final File LOREM_OUTPUT_FILE = new File("lorem_output.txt");

    @AfterClass
    public static void afterTests(){
        TEMP_OUTPUT_FILE.delete();
    }

    @Test
    public void loremTest() throws IOException {
        (new FileTokenizer(LOREM_FILE)).tokenizeTo(TEMP_OUTPUT_FILE);
        assertEquals(TEMP_OUTPUT_FILE.length(),LOREM_OUTPUT_FILE.length());
    }

    @Test
    public void lowCaseTest() throws IOException {
        // create test file
        File inputFile = new File("trivialTestFile.txt");
        String testString = "Some test string";
        Writer writer = (new FileWriter(inputFile)).append(testString);
        writer.close();
        //tokenize
        (new FileTokenizer(inputFile)).tokenizeTo(TEMP_OUTPUT_FILE);
        //read from tokenized file
        BufferedReader br = new BufferedReader(new FileReader(TEMP_OUTPUT_FILE));
        String actual = br.readLine();
        br.close();
        //test
        assertEquals(testString.toLowerCase(),actual);
    }
}
