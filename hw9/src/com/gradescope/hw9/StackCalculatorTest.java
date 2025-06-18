package com.gradescope.hw9;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.Assert.*;


/**
 * Tests for StackCalculator
 */
public class StackCalculatorTest {
    /**
     * Constructor test
     */
    @Test
    public void test_StackCalculatorConstructor() {
        StackCalculator s = new StackCalculator();
    }


    /**
     * method tests
     */
    @Test 
    public void test_evalRPN_add() {
        StackCalculator s = new StackCalculator();
        String[] plus = {"5", "3", "+"};
        assertEquals(8, s.evalRPN(plus));
    }

    @Test 
    public void test_evalRPN_subtract() {
        StackCalculator s = new StackCalculator();
        String[] sub = {"10", "2", "-"};
        assertEquals(8, s.evalRPN(sub));
    }

    @Test 
    public void test_evalRPN_multiply() {
        StackCalculator s = new StackCalculator();
        String[] mult = {"2", "4", "*"};
        assertEquals(8, s.evalRPN(mult));
    }

    @Test 
    public void test_evalRPN_divide() {
        StackCalculator s = new StackCalculator();
        String[] div = {"24", "3", "/"};
        assertEquals(8, s.evalRPN(div));
    }


    @Test
    public void test_calculateStream() {
        StackCalculator s = new StackCalculator();
        String input = "5 6 +";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        assertEquals(11, s.calculateStream(stream));
    }

}
