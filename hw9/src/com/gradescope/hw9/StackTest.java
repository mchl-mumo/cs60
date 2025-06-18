package com.gradescope.hw9;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;
import org.junit.Assert.*;


/**
 * Tests for Stack
 * 
 */
public class StackTest {
    /**
     * Constructor tests
     */
    @Test
    public void test_constructor() {
        Stack<String> s = new Stack<String>();
    }

    /**
     * Methoda tests
     */
    @Test
    public void test_isEmpty() {
        Stack<String> s = new Stack<String>();
        assertTrue(s.isEmpty());
    }

    @Test
    public void test_getSize() {
        Stack<String> s = new Stack<String>();
        assertEquals(0, s.getSize());
    }

    @Test
    public void test_push() {
        Stack<String> s = new Stack<String>();
        assertEquals(0, s.getSize());
        s.push("first in");
        assertEquals(1, s.getSize());
        s.push("second in");
        assertEquals(2, s.getSize());
    }

    @Test
    public void test_peek() {
        Stack<String> s = new Stack<String>();
        s.push("first in");
        assertEquals("first in", s.peek());
        assertEquals(1, s.getSize());
        s.push("second in");
        assertEquals("second in", s.peek());
        assertEquals(2, s.getSize());
    }

    @Test
    public void test_pop() {
        Stack<String> s = new Stack<String>();
        s.push("first in");
        s.push("second in");
        assertEquals(2, s.getSize());
        assertEquals("second in", s.pop());
        assertEquals(1, s.getSize());
        assertEquals("first in", s.pop());
        assertEquals(0, s.getSize());
    }

    @Test
    public void test_clear() {
        Stack<String> s = new Stack<String>();
        s.push("first in");
        s.push("second in");
        assertEquals(2, s.getSize());
        s.clear();
        assertEquals(0, s.getSize());
    }

    @Test
    public void test_equals() {
        Stack<String> s = new Stack<String>();
        Stack<String> c = new Stack<String>();
        Stack<String> d = new Stack<String>();
        s.push("first in");
        c.push("first in");
        d.push("other first");
        assertTrue(s.equals(c));
        assertFalse(s.equals(d));
    }

    @Test
    public void test_toString() {
        Stack<String> s = new Stack<String>();
        s.push("first in");
        s.push("second in");
        assertEquals("( second in first in )", s.toString());
    }
}