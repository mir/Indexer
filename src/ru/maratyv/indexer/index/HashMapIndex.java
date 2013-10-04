package ru.maratyv.indexer.index;

import ru.maratyv.indexer.Token;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:15 AM
 * Porsche is the only car
 */
public class HashMapIndex implements Index {
    private ConcurrentMap<String,SortedSet<Posting>> storage = new ConcurrentHashMap<String,SortedSet<Posting>>();

    @Override
    public synchronized void add(Token token) {
        Posting postingToAdd = new Posting(token.docID);
        if (storage.containsKey(token.term)) {
            SortedSet<Posting> postings = storage.get(token.term);
            if (toAddPosting(postings,postingToAdd)) {
                postings.add(postingToAdd);
            }
        } else {
            SortedSet<Posting> postings = new ConcurrentSkipListSet<Posting>();
            postings.add(postingToAdd);
            storage.put(token.term,postings);
        }
    }

    private boolean toAddPosting(SortedSet<Posting> postings, Posting postingToAdd) {
        SortedSet<Posting> postingsTail = postings.tailSet(postingToAdd);
        if (postingsTail == null || postingsTail.isEmpty()) {
            return true;
        }
        if (postingsTail.first().equals(postingToAdd)) {
            postingsTail.first().incrementFrequency();
            return false;
        }
        return true;
    }

    @Override
    public Collection<Posting> get(String term) {
        SortedSet<Posting> postingSortedSet = storage.get(term);
        if (postingSortedSet == null) {
            return new ArrayList<Posting>(0);
        }
        List<Posting> postingList = new ArrayList<Posting>();
        postingList.addAll(postingSortedSet);
        return postingList;
    }
}
