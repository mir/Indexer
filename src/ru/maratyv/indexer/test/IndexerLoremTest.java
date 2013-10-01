package ru.maratyv.indexer.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.DerictoryIsNotSpecified;
import ru.maratyv.indexer.FileIndexer;
import ru.maratyv.indexer.Indexer;

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

    private static Indexer indexer;

    @BeforeClass
    public static void loadText() throws IOException, DerictoryIsNotSpecified {
        indexer = new FileIndexer(new File("test Docs"));
    }

    @Test
    public void findLorem(){
        int found = indexer.find("lorem").size();
        assertEquals(3,found);
    }
}
