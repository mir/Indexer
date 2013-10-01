package ru.maratyv.indexer.tokenizers;

import ru.maratyv.indexer.Token;
import ru.maratyv.indexer.index.Index;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 9/30/13
 * Time: 7:12 PM
 * Porsche is the only car
 */
public interface Tokenizer {
    void addTokensTo(Index index) throws IOException;
}
