package ru.maratyv.indexer.index;

import ru.maratyv.indexer.Posting;
import ru.maratyv.indexer.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:15 AM
 * Porsche is the only car
 */
public class HashMapIndex implements Index {
    private HashMap<String,List<Posting>> storage = new HashMap<String,List<Posting>>();

    @Override
    public void add(Token token) {
        if (storage.containsKey(token.term)) {
            List<Posting> postings = storage.get(token.term);
            if (toAddPosting(postings,token.docID)) {
                postings.add(new Posting(token.docID));
            }
        } else {
            List<Posting> postings = new ArrayList<Posting>();
            postings.add(new Posting(token.docID));
            storage.put(token.term,postings);
        }
    }

    private boolean toAddPosting(List<Posting> postings, String docID) {
        for (Posting posting:postings) {
            if (posting.docID.equals(docID)) {
                posting.incrementFrequency();
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Posting> get(String term) {
        return storage.get(term);
    }
}
