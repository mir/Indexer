package ru.maratyv.indexer;

import ru.maratyv.indexer.index.Posting;

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
}
