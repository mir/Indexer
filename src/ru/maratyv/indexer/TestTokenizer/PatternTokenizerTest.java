package ru.maratyv.indexer.TestTokenizer;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.PatternStringTokenizer;
import ru.maratyv.indexer.StringTokenizer;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 6:11 PM
 * Porsche is the only car
 */
@RunWith(JUnit4.class)
public class PatternTokenizerTest {
    public static StringTokenizer tokenizer;

    @BeforeClass
    public static void setUp() throws IOException {
        tokenizer = new PatternStringTokenizer();
    }

    @Test
    public void stringTest(){
        String actual = tokenizer.tokenizeString("Some test * 123 string with _^& *(@#( symbols )*");
        String expected = "some test 123 string with symbols";
        assertEquals(expected,actual);
    }
}
