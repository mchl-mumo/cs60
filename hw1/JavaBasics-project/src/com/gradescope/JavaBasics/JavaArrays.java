package com.gradescope.JavaBasics;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

/**
 * Fill in the body of the methods below based upon the specification provided.
 * It may be helpful to look at the test cases provided in ArraysTests.java
 * to understand the intended behavior of the method.
 * 
 * All content is based upon problems at CodingBat.com.
 */

public class JavaArrays {

	/**
	 * Given an array of ints, return the number of 9's in the array.
	 * 
	 * Source: http://codingbat.com/prob/p184031 (answer available)
	 */
	public static int arrayCount9(int[] nums) {
		int count = 0;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] == 9) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Given an array of ints, return true if one of the first 4 elements in the
	 * array is a 9. The array length may be less than 4.
	 * 
	 * Source: http://codingbat.com/prob/p186031 (answer available)
	 * 
	 * I learnt how to use a variable to represent the upper limit of number of loops that can be either of two things
	 * in this case 4 or the lenght of the array, whichever is shorter.
	 */
	public static boolean arrayFront9(int[] nums) {
		int end = nums.length;
		if (end > 4) end = 4;  
		for (int i=0; i<end; i++) {
		if (nums[i] == 9) return true;
		}		  
		return false;
	}

	/**
	 * Given an array of ints, return true if .. 1, 2, 3, .. appears in the array
	 * somewhere.
	 * 
	 * Source: http://codingbat.com/prob/p136041 (answer available)
	 */
	public static boolean array123(int[] nums) {
		for (int i=0; i < (nums.length - 2); i++) {
			if (nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given an array of ints, return the number of times that two 6's are next to
	 * each other in the array plus the number of times where a 6 is followed by a
	 * 7.
	 * 
	 * Source: http://codingbat.com/prob/p110019 (answer available)
	 * 
	 */
	public static int array667(int[] nums) {
		int count = 0;
		for (int i=0; i < (nums.length-1); i++) {
		  if (nums[i] == 6) {
			if (nums[i+1] == 7 || nums[i+1] == 6) {
			  count++;
			}
		  }
		}
		return count;
	}

	/**
	 * Given an array of ints, we'll say that a triple is a value appearing 3 times
	 * in a row in the array. Return true if the array does not contain any triples.
	 * 
	 * Source: http://codingbat.com/prob/p170221 (answer available)
	 */
	public static boolean noTriples(int[] nums) {
  		for (int i=0; i < (nums.length-2); i++) {
			int current = nums[i];
			if (nums[i+1]==current && nums[i+2]==current) {
				return false;
			}	
  		}
  		return true;
	}

	/**
	 * Given an array of ints, return true if 6 appears as either the first or last
	 * element in the array. The array will be length 1 or more.
	 * 
	 * Source: http://codingbat.com/prob/p185685 (hint available)
	 */
	public static boolean firstLast6(int[] nums) {
		if (nums[0] == 6 || nums[nums.length-1] == 6) {
			return true;
		}
		return false;
	}

	/**
	 * Given an array of ints, return true if the array is length 1 or more, and the
	 * first element and the last element are equal.
	 * 
	 * Source: http://codingbat.com/prob/p118976 (hint available)
	 */
	public static boolean sameFirstLast(int[] nums) {
		if (nums.length > 0 && nums[0] == nums[nums.length-1]) {
			return true;
		}
		return false;
	}

	/**
	 * Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	 * Hint: Don't overthink this one. No computation required!
	 * 
	 * Source: http://codingbat.com/prob/p167011
	 */
	public static int[] makePi() {
		int[] retVal = new int[3];
		retVal[0] = 3;
		retVal[1] = 1;
		retVal[2] = 4;
		return retVal;
	}

	/**
	 * Given 2 arrays of ints, a and b, return true if they have the same first
	 * element or they have the same last element. Both arrays will be length 1 or
	 * more.
	 * 
	 * Source: http://codingbat.com/prob/p191991
	 */
	public static boolean commonEnd(int[] a, int[] b) {
		if (a[0] == b[0] || a[a.length-1] == b[b.length-1]) {
			return true;
		}
		return false;
	}

	/**
	 * Given an array of ints length 3, return the sum of all the elements.
	 * 
	 * Source: http://codingbat.com/prob/p175763
	 */
	public static int sum3(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		return sum;
	}

	/**
	 * Given an array of ints length 3, return an array with the elements "rotated
	 * left" so {1, 2, 3} yields {2, 3, 1}.
	 * 
	 * Source: http://codingbat.com/prob/p185139
	 */
	public static int[] rotateLeft3(int[] nums) {
		int first = nums[0];
		int second = nums[1];
		int third = nums[2];
		nums[0] = second;
		nums[1] = third;
		nums[2] = first;
		return nums;
	}

	/**
	 * Return the number of even ints in the given array. Note: the % "mod" operator
	 * computes the remainder, e.g. 5 % 2 is 1.
	 * 
	 * Source: http://codingbat.com/prob/p162010
	 */
	public static int countEvens(int[] nums) {
		int evens = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				evens++;
			}
		}
		return evens;
	}

	/**
	 * Given an array length 1 or more of ints, return the difference between the
	 * largest and smallest values in the array. Note: the built-in Math.min(v1, v2)
	 * and Math.max(v1, v2) methods return the smaller or larger of two values.
	 * 
	 * Source: http://codingbat.com/prob/p196640
	 */
	public static int bigDiff(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		for (int i=0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		return max - min;
	}

	/**
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest values
	 * in the array. If there are multiple copies of the smallest value, ignore just
	 * one copy, and likewise for the largest value. Use int division to produce the
	 * final average. You may assume that the array is length 3 or more.
	 * 
	 * Source: http://codingbat.com/prob/p136585
	 */
	public static int centeredAverage(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int total = 0;
		for (int i=0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
			total = total + nums[i];
		}
		return (total - max - min)/(nums.length - 2);
	}

	public static void main(String[] args) {
	}
}
