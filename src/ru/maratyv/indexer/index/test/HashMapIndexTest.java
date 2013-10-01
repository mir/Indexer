package ru.maratyv.indexer.index.test;

import org.junit.Test;
import org.junit.*;
import ru.maratyv.indexer.Token;
import ru.maratyv.indexer.index.HashMapIndex;
import ru.maratyv.indexer.index.Index;

import static org.junit.matchers.JUnitMatchers.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: mir
 * Date: 10/1/13
 * Time: 9:28 AM
 * Porsche is the only car
 */
public class HashMapIndexTest {
    private Index index;

    @Before
    public void setUp() {
        index = new HashMapIndex();
    }

    @Test
    public void testTwoTokens() throws Exception {
        index.add(new Token(1,"Hello"));
        index.add(new Token(7, "world"));
        index.add(new Token(13,"world"));
        index.add(new Token(18,"!"));
        assertThat(index.get("world"),hasItems(7,13));
    }

    @Test
    public void testNoElements(){
        assertNull(index.get("Any word"));
        index.add(new Token(1,"Hello"));
        assertNull(index.get(""));
    }
}
