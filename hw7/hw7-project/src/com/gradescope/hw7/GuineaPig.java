package com.gradescope.hw7;

/**
 * A guinea pig.
 */
public class GuineaPig implements Comparable<GuineaPig>, Squeakable {
	private int age;
	private String name;

	/**
	 * Initializes a new guinea pig object.
	 * 
	 * @param name - the name
	 * @param age  - the age
	 */
	public GuineaPig(String name, int age) {
		this.name = name;
		this.age = age; 
	}

	/**
	 * Initializes a new guinea pig object with default name "arya" and age 1 (Prof
	 * Wu's pet).
	 */
	public GuineaPig() {
		this("arya", 1);
	}

	/**
	 * Returns the name of this guinea pig.
	 */
	public String getName() {
		return name;
	}


	/**
	 * This method compares this GuineaPig to o gunieaPig
	 * if this gunieaPig is older than o gunieaPig, return positive value
	 * if this gunieaPig is younger than o returns negative value
	 * if the two guniea pigs have same age and name, returns 0
	 * 
	 * 
	 * @param o - GuniePig to compare to 
	 * @return negative, 0 or positive integer
	 */
	@Override
	public int compareTo(GuineaPig o) {
		if (this.age != o.age) {
			return this.age - o.age;
		} else if (this.name != o.name) {
			return this.name.compareTo(o.name);
		} else {
			return 0;
		}
	}

	@Override
	public String squeak() {
		return "Squeak! (Feed me!)";
	}
}
