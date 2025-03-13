package com.gradescope.hw5;

import java.util.Arrays;

/**
 * The Course class represents a class that has a code and a cap to the enrollment.
 * 
 * @author CS60 student
 */

public class Course {

    /**************************
     * Instance variables
     **************************/

    /**
     * The code of the class
     */
    private final String code;

    /**
     * The cap of the class
     */
    private final int cap;

    /*
     * The enrolled students
     */
    private Student[] enrolled;


    /***********************
     * Constructor
     ***********************/

    /**
     * Initializes a new course with input of the code and cap.
     * enrolled is initialized as an empty student list
     * 
     * @param code - The code of the class
     * @param cap - The cap of the class
     */

    public Course(String code, int cap) {
        this.code = code;
        this.cap = cap;
        this.enrolled = new Student[0];
    }


    /*********************
     * Non-static Methods
     *********************/

    public String getCode() {
        return code;
    }

    public int getCap() {
        return cap;
    }

    public Student[] getEnrolled() {
        return enrolled;
    }


    /**
     * Returns the total number of student objects in the array enrolled.
     * 
     * @return - length of enrolled
     */
    public int getNumEnrolled() {
        return enrolled.length;
    }


    /**
     * Enrolls a student into this Course.
     * A student can only be enrolled if the length of enrolled is less than cap of the Course.
     * If a student is successfully enrolled, the return is the new number of enrolled students otherwise -1.
     * 
     * @param student - student to be enrolled in course.
     * @return - new length of enrolled or -1
     */
    public int enrollStudent(Student student) {
        for (int index = 0; index < enrolled.length; index++) {
            if(enrolled[index] == student){
                return -1;
            }
        }

        if (enrolled.length == cap) {
            return -1;
        }
        
        int numEnrolledStudents = enrolled.length;
        Student[] updatedEnrolledStudents = new Student[numEnrolledStudents + 1];
        for (int index = 0; index < numEnrolledStudents; index++) {
            updatedEnrolledStudents[index] = enrolled[index];
        }
        updatedEnrolledStudents[numEnrolledStudents] = student;
        enrolled = updatedEnrolledStudents;
        return enrolled.length;
    }

    /**
     * Returns a string representation of enrolled. 
     * Each Student in enrolled is converted to a string by the Student object .toString()
     * 
     * @return - string representation of enrolled
     */
    public String getStudents() {
        return Arrays.toString(enrolled);
    }
    
}
