package com.gradescope.hw5;
import static org.junit.Assert.*;
import org.junit.Test;


public class CookieTest {
    @Test
    public void testFileSetUp() {
        System.out.println("One test ran!");
        assertTrue(3 < 4);
    }

    /********************
	 * constructors
	 ********************/    
    @Test
    public void testCookieSugar() {
        new Cookie();
    }

    @Test
    public void testCookieChocolateChip() {
        new Cookie("chocolate chip");
    }

    @Test
    public void testCookieGlutenFree() {
        new Cookie("gluten free");
    }

    @Test
    public void testCookieOther() {
        new Cookie("other");
    }

    /********************
	 * getters
	 ********************/

     @Test
     public void testGetType() {
        Cookie sugarCookie = new Cookie();
        assertEquals("sugar", sugarCookie.getType());

        Cookie chocoCookie = new Cookie("chocolate chip");
        assertEquals("chocolate chip", chocoCookie.getType());

        Cookie glutCookie = new Cookie("gluten free");
        assertEquals("gluten free", glutCookie.getType());

        Cookie otherCookie = new Cookie("other");
        assertEquals("other", otherCookie.getType());
    }

    @Test 
    public void testGetCalories() {
        Cookie sugarCookie = new Cookie();
        assertEquals(400, sugarCookie.getCalories());

        Cookie chocoCookie = new Cookie("chocolate chip");
        assertEquals(500, chocoCookie.getCalories());

        Cookie glutCookie = new Cookie("gluten free");
        assertEquals(400, glutCookie.getCalories());

        Cookie otherCookie = new Cookie("other");
        assertEquals(500, otherCookie.getCalories());
    }

    /********************
	 * methods
	 ********************/

    @Test
    public void testListIngredients() {
        Cookie sugarCookie = new Cookie();
        assertEquals("[butter, sugar, eggs, flour]", sugarCookie.listIngredients());

        Cookie chocoCookie = new Cookie("chocolate chip");
        assertEquals("[chocolate chips, butter, sugar, eggs, flour]", chocoCookie.listIngredients());

        Cookie glutCookie = new Cookie("gluten free");
        assertEquals("[eggs, sugar, peanut butter, chocolate chips]", glutCookie.listIngredients());

        Cookie otherCookie = new Cookie("other");
        assertEquals("[others, butter, sugar, eggs, flour]", otherCookie.listIngredients());
    }

    @Test
    public void testAddIngredient() {
        String newIngredient = new String("newIngredient");
        Cookie sugarCookie = new Cookie();
        sugarCookie.addIngredient(newIngredient);
        assertEquals("[butter, sugar, eggs, flour, newIngredient]", sugarCookie.listIngredients());
    }


    /********************************
	 * Static Methods
	 ********************************/

     @Test
     public void testCookieCountFrom0to1() {
        Cookie.resetCookieCount();
        assertEquals(0, Cookie.getCookieCount());
        new Cookie();
        assertEquals(1, Cookie.getCookieCount());
     }

     @Test
     public void testCookieCountFrom0to4(){
        Cookie.resetCookieCount();
        assertEquals(0, Cookie.getCookieCount());
        new Cookie();
        new Cookie();
        new Cookie();
        new Cookie();
        assertEquals(4, Cookie.getCookieCount());
     }

    @Test
    public void testRightNumberOfCookies(){
        assertEquals(6, Cookie.rightNumberOfCookies());
    }    
    
    @Test
    public void testIsDeliciousCookieType() {
        assertTrue(Cookie.isDeliciousCookieType("chocolate"));
        assertFalse(Cookie.isDeliciousCookieType("notChocolate"));
    }

    /********************************
	 * Constructors CookieBox
	 ********************************/

    @Test
    public void testCookieBox() {
        new CookieBox();
    }

    /********************************
	 * Non-static Methods CookieBox
	 ********************************/

    @Test
    public void testAddCookieGetCalories() {
        Cookie c = new Cookie();
        CookieBox cb = new CookieBox();
        assertEquals(0, cb.totalCaloriesInBox());
        cb.addCookie(c);
        assertEquals(c.getCalories(), cb.totalCaloriesInBox());
    }
}
