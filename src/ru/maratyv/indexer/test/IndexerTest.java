package ru.maratyv.indexer.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.maratyv.indexer.DerictoryIsNotSpecified;
import ru.maratyv.indexer.FileIndexer;
import ru.maratyv.indexer.Indexer;
import ru.maratyv.indexer.index.Posting;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:44 PM
 * Porsche is the only car
 */
@RunWith(JUnit4.class)
public class IndexerTest {

    //Test comment
    private static Indexer indexer;
    private static final File DIR_TO_INDEX = new File("test Docs");

    @BeforeClass
    public static void loadText() throws IOException, DerictoryIsNotSpecified {
        indexer = new FileIndexer(DIR_TO_INDEX);
    }

    @Test
    public void findLorem() throws IOException {
        // number of files containing lorem
        //new commment
        //Commit 1
        //Commit 2
        int actual = indexer.find("lorem").size();
        int expected = countFilesWithWords("lorem","lorem");
        assertEquals(expected,actual);
    }

    @Test
    public void findBoth() throws IOException {
        int actual = indexer.findBoth("lorem", "dolor").size();
        int expected = countFilesWithWords("lorem","dolor");
        assertEquals(expected,actual);
    }

    private int countFilesWithWords(String word1, String word2) throws IOException {
        int expected = 0;
        for (File file:DIR_TO_INDEX.listFiles()) {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            try {
                String curLine = bf.readLine();
                while (curLine != null) {
                    if (curLine.toLowerCase().contains(word1) &&
                            curLine.toLowerCase().contains(word2)) {
                        expected++;
                        break;
                    }
                    curLine = bf.readLine();
                }
            } finally {
                bf.close();
            }
        }
        return expected;
    }
}
