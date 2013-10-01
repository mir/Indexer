package ru.maratyv.indexer;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:04 AM
 * Porsche is the only car
 */
public class Token {
    public final String docID;
    public final String term;

    public Token(String docID, String term) {
        this.docID = docID;
        this.term = term;
    }


    @Override
    public String toString() {
        return term + ":" + docID;
    }
}
