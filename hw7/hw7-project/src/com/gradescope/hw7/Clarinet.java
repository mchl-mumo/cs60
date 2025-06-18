package com.gradescope.hw7;


/**
 * Class Clarinet has key Bb
 * It is a child of Instrument and implements Squeakable
 * 
 * 
 */
public class Clarinet extends Instrument implements Squeakable{

    /**
     * Constructor utilizes Instument constructor
     */
    public Clarinet() {
        super("Bb");
    }

    /**
     * Implements squeak
     * 
     * @return - string
     */
    @Override
    public String squeak() {
        return "Squeak! (Need more practice...)";
    }
    
}
