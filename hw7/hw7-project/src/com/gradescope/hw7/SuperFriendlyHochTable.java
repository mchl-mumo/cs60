package com.gradescope.hw7;

import java.util.ArrayList;

/**
 * A table at the Hoch with chairs and people. Hoch tables are never full!
 * (There's always room for N+1.) At a super friendly table, whenever a person
 * is or removed added, they say hello or bye to everyone else at the table.
 * When class starts, everyone says bye.
 */
public class SuperFriendlyHochTable extends HochTable {
	/**
	 * The default number of chairs.
	 */
	public static final int NUMBER_OF_CHAIRS = 10;

	/**
	 * Constructs a table with the default number of chairs.
	 */
	public SuperFriendlyHochTable() {
		super(SuperFriendlyHochTable.NUMBER_OF_CHAIRS);
	}

	/**
	 * Constructs a table with the specified number of chairs.
	 * 
	 * @param capacity - the number of seats
	 * @throws IllegalArgumentException if the capacity is less than 0
	 */
	public SuperFriendlyHochTable(int capacity) {
		super(capacity);
	}


	/**
	 * Adds a person to this table if there is space.
	 * 
	 * @param name - the name of the person to add
	 * @return a welcome message
	 */
	public String addPerson(String name) {
		String welcome = super.addPerson(name);

		String thanks = "";
		if (getNumPeople() > 1) {
			String oldNames = getPeopleList().subList(0, getPeopleList().size() - 1).toString();
			oldNames = oldNames.substring(1, oldNames.length() - 1); // strip square brackets
			thanks = "Thanks " + oldNames + "!!!!!";
		}

		if (welcome != "" && thanks != "") {
			welcome += " ";
		}

		return welcome + thanks;
	}

	/**
	 * Removes a person from this table.
	 * 
	 * @param name - the name of the person to remove
	 * @return a goodbye message
	 */
	public String removePerson(String name) {
		String text = super.removePerson(name);
		String out = "Bye " + name + ".";
		if (text.compareTo(out) == 0) {
			String names = this.getPeople();
			names = names.substring(1, names.length() - 1); // strip square brackets
			return "Bye " + name + ". " + "Bye " + names + ".";
		}
		return text;	
	}

	/**
	 * Clears the table as everyone goes to class.
	 * 
	 * @return a goodbye message
	 */
	public String classStartingSoon() {
		String text = super.classStartingSoon();
		if (text == "(Silence - everyone runs to class.)") {
			return "Bye everyone!";
		}
		return text;
	}
}
