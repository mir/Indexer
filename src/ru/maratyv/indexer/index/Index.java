package ru.maratyv.indexer.index;

import ru.maratyv.indexer.Token;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:00 AM
 * Porsche is the only car
 */
public interface Index {
    public void add(Token token);
    public Collection<Posting> get(String word);
}
