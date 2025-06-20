package com.gradescope.JavaBasics;

/**
 * Fill in the body of the methods below based upon the specification provided.
 * It may be helpful to look at the test cases provided in
 * StringsTests.java to understand the intended behavior of the method.
 * 
 * All content is based upon problems at CodingBat.com.
 */

public class Strings {

	/**
	 * Given a string, return a new string where "not " has been added to the front.
	 * However, if the string already begins with "not", return the string
	 * unchanged. Note: use .equals() to compare 2 strings.
	 * 
	 * Source: http://codingbat.com/prob/p191914
	 */
	public static String notString(String str) {
		if (str.length() >= 3 && str.substring(0,3).equals("not")) {
			return str;	
		}
		return "not ".concat(str);	
	}

	/**
	 * Given a non-empty string and an int n, return a new string where the char at
	 * index n has been removed. The value of n will be a valid index of a char in
	 * the original string (i.e. n will be in the range 0..str.length()-1
	 * inclusive).
	 * 
	 * Source: http://codingbat.com/prob/p190570
	 */
	public static String missingChar(String str, int n) {
		return str.substring(0,n) + str.substring(n+1);
	}

	/**
	 * Given a string, return a new string where the first and last chars have been
	 * exchanged.
	 * 
	 * Source: http://codingbat.com/prob/p123384
	 */
	public static String frontBack(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return str.substring(str.length()-1) + str.substring(1, str.length()-1) + str.substring(0,1);
	}

	/**
	 * Given a string, we'll say that the front is the first 3 chars of the string.
	 * If the string length is less than 3, the front is whatever is there. Return a
	 * new string which is 3 copies of the front.
	 * 
	 * Source: http://codingbat.com/prob/p136351
	 */
	public static String front3(String str) {
		if (str.length() < 3) {
			return str + str + str;
		} else {
			return str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3);
		}
	}

	/**
	 * Given a string, take the last char and return a new string with the last char
	 * added at the front and back, so "cat" yields "tcatt". The original string
	 * will be length 1 or more.
	 * 
	 * Source: http://codingbat.com/prob/p161642
	 */
	public static String backAround(String str) {
		return str.substring(str.length()-1) + str + str.substring(str.length()-1);
	}

	/**
	 * Given a string, take the first 2 chars and return the string with the 2 chars
	 * added at both the front and back, so "kitten" yields"kikittenki". If the
	 * string length is less than 2, use whatever chars are there.
	 * 
	 * Source: http://codingbat.com/prob/p183592
	 */
	public static String front22(String str) {
		if (str.length() < 2) {
			return str + str + str;
		} else {
			return str.substring(0, 2) + str + str.substring(0, 2);
		}
	}

	/**
	 * Given a string, return true if the string starts with "hi" and false
	 * otherwise.
	 * 
	 * Source: http://codingbat.com/prob/p191022
	 */
	public static boolean startHi(String str) {
		if (str.length() > 1 && str.substring(0, 2).equals("hi")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Given a string, return a string made of the first 2 chars (if present),
	 * however include first char only if it is 'o' and include the second only if
	 * it is 'z', so "ozymandias" yields "oz".
	 * 
	 * Source: http://codingbat.com/prob/p199720
	 */
	public static String startOz(String str) {
		String first = "";
		String second = "";
		if (str.length() > 0 && str.substring(0,1).equals("o")) {
			first = "o";
		}
		if (str.length() > 1 && str.substring(1,2).equals("z")) {
			second = "z";
		}
		return first + second;
	}

	public static void main(String[] args) {
		// You can add debugging statements here to test your methods!
	}

}
