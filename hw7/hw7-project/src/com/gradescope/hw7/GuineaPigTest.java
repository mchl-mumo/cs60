package com.gradescope.hw7;
import static org.junit.Assert.*;

import org.junit.Test;

public class GuineaPigTest {

    @Test
    public void test_defaultConstructor() {
        GuineaPig pig = new GuineaPig();
        assertEquals("arya", pig.getName());
    }

    public void test_gunieaPigConstructor() {
        GuineaPig pig = new GuineaPig("auto", 2);
        assertEquals("auto", pig.getName());
    }

    public void test_implementsComparable() {
        Comparable<GuineaPig> pig = new GuineaPig();
    }

    public void test_compareToYoungerAge() {
        Comparable<GuineaPig> pig1 = new GuineaPig("auto", 2);
        GuineaPig pig2 = new GuineaPig("auto", 3);
        assertTrue(pig1.compareTo(pig2) < 0);
    }

    public void test_compareToName() {
        Comparable<GuineaPig> pig1 = new GuineaPig("auto", 3);
        GuineaPig pig2 = new GuineaPig("beta", 3);
        assertTrue(pig1.compareTo(pig2) < 0);
    }

    public void test_squeak() {
        GuineaPig pig = new GuineaPig();
        assertEquals("Squeak! (Feed me)", pig.squeak());
    }

    public void test_implementsSqueakable() {
        Squeakable pig = new GuineaPig();
    }

    public void test_squeakableSqueekes() {
        Squeakable pig = new GuineaPig();
        assertEquals("Squeak! (Feed me)", pig.squeak());
    }
}
