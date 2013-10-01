package ru.maratyv.indexer.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.Indexer;
import ru.maratyv.indexer.MIndexer;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:44 PM
 * Porsche is the only car
 */
@RunWith(JUnit4.class)
public class IndexerLoremTest {

    private static Indexer mindexer;

    @BeforeClass
    public static void loadText() throws IOException {
        mindexer = new MIndexer(new File("test_input.txt"));
    }

    @Test
    public void findLorem(){
        int found = mindexer.find("lorem").size();
        assertEquals(4,found);
    }
}
