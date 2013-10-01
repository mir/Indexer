package ru.maratyv.indexer.index;

import ru.maratyv.indexer.index.Index;
import ru.maratyv.indexer.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:15 AM
 * Porsche is the only car
 */
public class HashMapIndex implements Index {
    private HashMap<String,List<Integer>> storage = new HashMap<String,List<Integer>>();

    @Override
    public void add(Token token) {
        if (storage.containsKey(token.word)) {
            storage.get(token.word).add(token.position);
        } else {
            List<Integer> positions = new ArrayList<Integer>();
            positions.add(token.position);
            storage.put(token.word,positions);
        }
    }

    @Override
    public List<Integer> get(String word) {
        return storage.get(word);
    }
}
