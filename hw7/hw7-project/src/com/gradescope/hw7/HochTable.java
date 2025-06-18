package com.gradescope.hw7;

import java.util.ArrayList;

/**
 * A table at the Hoch with chairs and people. Hoch tables are never full!
 * (There's always room for N+1.)
 */
public class HochTable extends Table {
	/**
	 * The default number of chairs.
	 */
	public static final int NUMBER_OF_CHAIRS = 6;

	/**
	 * Constructs a table with the default number of chairs.
	 */
	public HochTable() {
		super(HochTable.NUMBER_OF_CHAIRS);
	}

	/**
	* Constructs a Hochtable with the specified number of chairs.
	* 
	* @param capacity - the number of seats
	* @throws IllegalArgumentException if the capacity is less than 0
	*/
	public HochTable(int capacity) {
		super(capacity);
	}

	/**
	 * Returns true because Hoch tables are never full.
	 */
	public boolean emptySeat() {
		return true;
	}

	/**
	 * Adds a person to this table if there is space.
	 * 
	 * @param name the name of the person to add
	 * @return a welcome message
	 */
	public String addPerson(String name) {
		// add a chair if needed
		if (this.getNumChairs() == this.getNumPeople()) {
			this.addChair();
		}	

		// greet the person
		return super.addPerson(name);
	}

	/**
	 * Clears the table as everyone goes to class.
	 * 
	 * @return a goodbye message
	 */
	public String classStartingSoon() {
		String message;
		if (this.getNumPeople() > 1) {
			message = "(Silence - everyone runs to class.)";
		} else {
			message = "(Silence - no one is here to say goodbye.)";
		}
		this.resetNumPeople();
		this.resetPeople();
		return message;
	}
}
