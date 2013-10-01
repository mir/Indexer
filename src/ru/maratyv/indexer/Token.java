package ru.maratyv.indexer;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:04 AM
 * Porsche is the only car
 */
public class Token {
    public final int position;
    public final String word;

    public Token(int position, String word) {
        this.position = position;
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (position != token.position) return false;
        if (!word.equals(token.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + word.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return word + ":" + position;
    }
}
