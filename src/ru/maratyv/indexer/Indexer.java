package ru.maratyv.indexer;

import ru.maratyv.indexer.index.Posting;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:51 PM
 * Porsche is the only car
 */
public interface Indexer {
    public Collection<Posting> find(String word);

    /**
     * Index file if it is not a directory.
     * If inputFile is a directory index all files in this directory.
     * @param inputFile
     */
    public void index(File inputFile) throws IOException, DerictoryIsNotSpecified;
}
