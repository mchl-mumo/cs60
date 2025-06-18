package com.gradescope.hw7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClarinetTest {
    @Test
    public void test_clarinetConstructor() {
        Clarinet clar = new Clarinet();
    }

    @Test 
    public void test_getKey() {
        Clarinet clar = new Clarinet();
        assertEquals("Bb", clar.getKey());
    }

    @Test
    public void test_staticInstrument() {
        Instrument inst = new Clarinet();
    }

    @Test
    public void test_squeak() {
        Clarinet clar = new Clarinet();
        assertEquals("Squeak! (Need more practice...)", clar.squeak());
    }

    @Test
    public void test_implementsSqueakable() {
        Squeakable clar = new Clarinet();
    }

    @Test
    public void test_squeakableSqueekes() {
        Squeakable clar = new Clarinet();
        assertEquals("Squeak! (Need more practice...)", clar.squeak());
    }
}
