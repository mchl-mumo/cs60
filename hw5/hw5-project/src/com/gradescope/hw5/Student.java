package com.gradescope.hw5;

/**
 * The Student class represents a student that has a name and id
 * 
 * 
 * @author CS60 student
 */

public class Student {

    /**************************
     * Instance variables
     **************************/

    /**
     * The name of the student
     */
    private String name;

    /**
     * The id of the student
     */
    private final long id;

    /*************************
     * Constructor
     *************************/

    /**
     * Initializes a new student with input of name and id.
     * 
     * @param name - The name of the student
     * @param id - The id of the student
     */ 

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    /************************
     * Non-static Methods
     ************************/

    public String getName(){
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String newName) {
        name = newName;
    }

    
    /**
     * Returns a string representation of this object. 
     * The string representation consists of the name of the Student followed by a space, then the id of the Student in square brackets.
     * 
     * @return - string representation of the object
     * 
     */

    @Override
    public String toString() {
        return "" + name + " [" + id + "]";
    }

    /**
     * Compares this Student to another Student.
     * The result is true if and only if the id of this Student and the id of the specified Student are the same number.
     * 
     * @param stud - The Student to compare this Student against
     * @return - true if the two Students have the same id else false
     */
    public boolean equals(Student stud) {
        return this.id == stud.id;
    }
}
