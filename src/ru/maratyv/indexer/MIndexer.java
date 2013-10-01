package ru.maratyv.indexer;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:33 PM
 * Porsche is the only car
 */
public class MIndexer implements Indexer{

    private File inputFile;

    public MIndexer(File inputFile) {
        inputFile = inputFile;
    }

    public List<Integer> find(String word) {
        return new ArrayList<Integer>(0);
    }
}
