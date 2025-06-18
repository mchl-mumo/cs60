package com.gradescope.hw9;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Stack Calculator performs reverse polish notation calculations.
 * 
 * @param args
 */
public class StackCalculator {
    private Stack<String> values;


    /**
     * Stack Contructor
     */
    public StackCalculator() {
        values = new Stack<String>();
    }

    /**
     * Performs calculations on reverse polish notation list of strings
     * 
     * @param instructions - list of strings in reverse polish notation
     * @return - integer that is the solution of the calculation
     * 
     */
    public int evalRPN(String[] instructions) {
        for(String instruction: instructions) {
            if (instruction.equals("+")) {
                int val1 = Integer.parseInt(values.pop());
                int val2 = Integer.parseInt(values.pop());
                int res = val2 + val1;
                values.push(Integer.toString(res));
            } else if (instruction.equals("-")) {
                int val1 = Integer.parseInt(values.pop());
                int val2 = Integer.parseInt(values.pop());
                int res = val2 - val1;
                values.push(Integer.toString(res));
            } else if (instruction.equals("*")) {
                int val1 = Integer.parseInt(values.pop());
                int val2 = Integer.parseInt(values.pop());
                int res = val2 * val1;
                values.push(Integer.toString(res));
            } else if (instruction.equals("/")) {
                int val1 = Integer.parseInt(values.pop());
                int val2 = Integer.parseInt(values.pop());
                int res = val2 / val1;
                values.push(Integer.toString(res));
            } else {
                values.push(instruction);
            }
        }
        return Integer.parseInt(values.pop());
    }

    /**
     * Calculates user entered input in reverse polish notation
     * 
     * @param stream - information from user
     * @return - integer that is the solution of the calculation
     */
    public int calculateStream(InputStream stream) {
        try (Scanner scan = new Scanner(stream)) {
            String in = scan.nextLine();
            String[] instructions = in.split(" ");
            int result = evalRPN(instructions);
            System.out.println(result);
            return result;
        }
    }
 

    /**
     * Prompts user for input in reverse polish notation and performs calculation
     * 
     * @return - integer that is the solution of the calculation
     */
    public int calculateUser() {
        return calculateStream(System.in);
    }
 
    /**
     * Reads reverse polish notation from a file and performs calculation
     * 
     * @param filename - relative path of file to read from
     * @return - integer that is the solution of the calculation
     */
    public int calculateFile(String filename) {
        Path p = Path.of(filename).toAbsolutePath();
        try (InputStream is = Files.newInputStream(p)) {
            return calculateStream(is);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
 
    public static void main(String[] args) {
        StackCalculator calc = new StackCalculator();
        calc.calculateUser();
        calc.calculateFile("hw9/eqn.txt");
    }
}
