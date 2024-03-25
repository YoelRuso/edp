package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

public class DictRETest {

    @Test
    public void testAddAndGet() {
        DictRE<String, Integer> dict = new DictRE<>();
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);

        assertEquals(1, dict.get("one"));
        assertEquals(2, dict.get("two"));
        assertEquals(3, dict.get("three"));
    }

    @Test
    public void testRemove() {
        DictRE<String, Integer> dict = new DictRE<>();
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);

        dict.remove("two");

        assertNull(dict.get("two"));
        assertEquals(1, dict.get("one"));
        assertEquals(3, dict.get("three"));
    }

    @Test
    public void testResize() {
        DictRE<String, Integer> dict = new DictRE<>(2);
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);

        assertEquals(1, dict.get("one"));
        assertEquals(2, dict.get("two"));
        assertEquals(3, dict.get("three"));
    }

    @Test
    public void testKeys() {
        DictRE<String, Integer> dict = new DictRE<>();
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);

        assertTrue(dict.keys().contains("one"));
        assertTrue(dict.keys().contains("two"));
        assertTrue(dict.keys().contains("three"));
        assertFalse(dict.keys().contains("four"));
    }

    @Test
    public void testValues() {
        DictRE<String, Integer> dict = new DictRE<>();
        dict.add("one", 1);
        dict.add("two", 2);
        dict.add("three", 3);

        assertTrue(dict.values().contains(1));
        assertTrue(dict.values().contains(2));
        assertTrue(dict.values().contains(3));
        assertFalse(dict.values().contains(4));
    }


}
