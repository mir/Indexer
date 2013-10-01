package ru.maratyv.indexer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 4:51 PM
 * Porsche is the only car
 */
public interface Indexer {
    public List<Integer> find(String word);
}
