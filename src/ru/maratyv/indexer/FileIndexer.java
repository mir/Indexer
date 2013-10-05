package ru.maratyv.indexer;

import ru.maratyv.indexer.index.HashMapIndex;
import ru.maratyv.indexer.index.Index;
import ru.maratyv.indexer.index.Posting;
import ru.maratyv.indexer.tokenizers.FileTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:33 PM
 * Porsche is the only car
 */
public class FileIndexer implements Indexer {

    private Index index = new HashMapIndex();

    public FileIndexer() {
    }

    public FileIndexer(File inputFile) throws IOException, DerictoryIsNotSpecified {
        index(inputFile);
    }

    public Collection<Posting> find(String term) {
        if (term == null) return new ArrayList<Posting>(0);
        Collection<Posting> found = index.get(term.toLowerCase());
        if (found == null) found = new ArrayList<Posting>(0);
        return found;
    }

    @Override
    public void index(File inputFile) throws IOException, DerictoryIsNotSpecified {
        if (inputFile.isFile()) {
            index(inputFile);
        } else if (inputFile.isDirectory()) {
            for (File file:inputFile.listFiles()) {
                FileTokenizer ft = new FileTokenizer(file);
                ft.addTokensTo(index);
            }
        } else {
            throw new DerictoryIsNotSpecified();
        }
    }
}
