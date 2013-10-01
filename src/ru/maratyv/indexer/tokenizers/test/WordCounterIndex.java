package ru.maratyv.indexer.tokenizers.test;

import ru.maratyv.indexer.Token;
import ru.maratyv.indexer.index.Index;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 10:15 AM
 * Porsche is the only car
 */
public class WordCounterIndex implements Index {
    final private String wordToCount;
    private int count = 0;

    public WordCounterIndex(String wordToCount) {
        if (wordToCount == null) wordToCount = "";
        this.wordToCount = wordToCount;
    }

    @Override
    public void add(Token token) {
        if (wordToCount.equals(token.word)) {
            count++;
        }
    }

    @Override
    public List<Integer> get(String word) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
