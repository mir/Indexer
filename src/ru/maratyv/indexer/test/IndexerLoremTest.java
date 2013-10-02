package ru.maratyv.indexer.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.DerictoryIsNotSpecified;
import ru.maratyv.indexer.FileIndexer;
import ru.maratyv.indexer.Indexer;

import java.io.*;
import java.util.Scanner;

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
    private static final File DIR_TO_INDEX = new File("test Docs");

    @BeforeClass
    public static void loadText() throws IOException, DerictoryIsNotSpecified {
        indexer = new FileIndexer(DIR_TO_INDEX);
    }

    @Test
    public void findLorem() throws IOException {
        // number of files containing lorem
        int found = indexer.find("lorem").size();
        int expected = 0;
        for (File file:DIR_TO_INDEX.listFiles()) {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            try {
                String curLine = bf.readLine();
                while (curLine != null) {
                    if (curLine.toLowerCase().contains("lorem")) {
                        expected++;
                        break;
                    }
                    curLine = bf.readLine();
                }
            } finally {
                bf.close();
            }
        }
        assertEquals(expected,found);
    }
}
