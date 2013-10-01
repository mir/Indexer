package ru.maratyv.indexer.tokenizers.test;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.index.Index;
import ru.maratyv.indexer.tokenizers.FileTokenizer;
import ru.maratyv.indexer.tokenizers.Tokenizer;

import java.io.*;

import static junit.framework.Assert.assertFalse;
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
        Tokenizer tokenizer = new FileTokenizer(LOREM_FILE);
        Index index = new WordCounterIndex("lorem");
        tokenizer.addTokensTo(index);
        assertEquals("4", index.toString());
    }

    @Test
    public void lowCaseTest() throws IOException {
        // create test file
        String testString = "0 2 4";
        Writer writer = (new FileWriter(TEMP_OUTPUT_FILE)).append(testString);
        writer.close();
        //tokenize
        Tokenizer tokenizer = new FileTokenizer(TEMP_OUTPUT_FILE);
        StringIndex stringIndex = new StringIndex();
        tokenizer.addTokensTo(stringIndex);
        //test
        assertEquals("0:0 2:2 4:4", stringIndex.toString());
    }
}
