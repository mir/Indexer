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
        index.add(new Token("1","hello",0));
        index.add(new Token("1","hello","hello ".length()));
        index.add(new Token("1","hello","hello hello ".length()));
        index.add(new Token("2","hello",0));
        index.add(new Token("1", "world","hello hello hello ".length()));
        index.add(new Token("1", "world","hello hello hello world ".length()));
        index.add(new Token("2","world", "hello ".length()));
        index.add(new Token("3","world",0));
        index.add(new Token("1","bla","hello hello hello world world ".length()));
        index.add(new Token("3","bla","hello world ".length()));
        assertEquals(3,index.get("world").size());
        assertEquals(2,index.get("hello").size());
        assertEquals(2,index.get("bla").size());
    }

    @Test
    public void testNoElements(){
        assertTrue(index.get("Any term").isEmpty());
        index.add(new Token("1","Hello",1));
        assertTrue(index.get("").isEmpty());
    }
}
