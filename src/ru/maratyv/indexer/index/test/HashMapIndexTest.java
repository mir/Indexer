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
        index.add(new Token("1","hello"));
        index.add(new Token("1","hello"));
        index.add(new Token("1","hello"));
        index.add(new Token("2","hello"));
        index.add(new Token("1", "world"));
        index.add(new Token("1", "world"));
        index.add(new Token("2","world"));
        index.add(new Token("3","world"));
        index.add(new Token("1","bla"));
        index.add(new Token("3","bla"));
        assertEquals(3,index.get("world").size());
        assertEquals(2,index.get("hello").size());
        assertEquals(2,index.get("bla").size());
    }

    @Test
    public void testNoElements(){
        assertNull(index.get("Any term"));
        index.add(new Token("1","Hello"));
        assertNull(index.get(""));
    }
}
