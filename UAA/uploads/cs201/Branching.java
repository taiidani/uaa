package branching;

import java.util.Scanner;

public class Branching {

    /**
     * This is a simple grade letter calculator. It uses the grade point that you
     * received and determines the letter grade from that.
     */
    public static void main(String[] args) {
        System.out.print("What percentage did you get? ");
        Scanner input = new Scanner(System.in);
        
        double grade = input.nextDouble();
        char letterGrade;
        boolean passed = true;
        String passedOutput;
        
        // ---------------------------------------------------------
        
        //A very *wrong* way to do this. You'll never get an A.
        if(grade >= 90) letterGrade = 'A';
        if(grade >= 80) letterGrade = 'B';
        if(grade >= 70) letterGrade = 'C';
        if(grade >= 60) letterGrade = 'D';
        if(grade < 60) letterGrade = 'F';
        
        //A correct but less attractive way to determine the grade
        /*if(grade >= 90) letterGrade = 'A';
        if(grade >= 80 && grade < 90) letterGrade = 'B';
        if(grade >= 70 && grade < 80) letterGrade = 'C';
        if(grade >= 60 && grade < 70) letterGrade = 'D';
        if(grade < 60) letterGrade = 'F';*/
        
        //A better way to do this, using if-else. This works.
        /*if(grade >= 90) letterGrade = 'A';
        else if(grade >= 80) letterGrade = 'B';
        else if(grade >= 70) letterGrade = 'C';
        else if(grade >= 60) letterGrade = 'D';
        else letterGrade = 'F';*/
        
        //If you use braces, you can have many lines of code per if statement
        /*if(grade >= 90) {
            letterGrade = 'A';
            passed = true;
        }
        else if(grade >= 80) {
            letterGrade = 'B';
            passed = true;
        }
        else if(grade >= 70) {
            letterGrade = 'C';
            passed = true;
        }
        else if(grade >= 60) {
            letterGrade = 'D';
            passed = false;
        }
        else {
            letterGrade = 'F';
            passed = false;
        }*/
        
        // ---------------------------------------------------------
        
        //Calculating passed by itself
        /*if(letterGrade == 'A' || letterGrade == 'B' || letterGrade == 'C') {
            passed = true;
        }
        else if(letterGrade == 'D' || letterGrade == 'F') {
            passed = false;
        }
        else {
            System.out.println("Surely you didn't get something else...");
        }*/
        
        //Switch statements could also be used if you only need to compare literals
        /*switch(letterGrade) {
            case 'A':
            case 'B':
            case 'C':
                passed = true;
                break;
                
            case 'D':
            case 'F':
                passed = false;
                break;
            
            default:
                System.out.println("Surely you didn't get something else...");
        }*/
        
        //Or just assign directly
        //passed = (letterGrade == 'A' || letterGrade == 'B' || letterGrade == 'C');
        
        // ---------------------------------------------------------
        
        //Next you need to determine the screen output for passing
        /*if(passed) {
            passedOutput = "Passed";
        }
        else {
            passedOutput = "Failed";
        }*/
        
        //Or can then use a ternary operator to determine the output text
        //passedOutput = (passed) ? "Passed" : "Failed";
        
        // ---------------------------------------------------------
        
        //Print out the letter grade using proper grammar
        /*System.out.print("This earns you a");
        if(letterGrade == 'A' || letterGrade == 'F') {
            System.out.print("n");
        }     
        System.out.println(" " + letterGrade + ".");
        
        //Print whether the user passed or not
        System.out.println("You " + passedOutput + "!");*/
        
        // ---------------------------------------------------------
        
        //stringComparison(passedOutput);
    }
    
    /**
     * Comparing objects is substantially different than comparing primitives.
     * Here is an example of comparing two strings
     */
    public static void stringComparison(String passedOutput) {
        //If anotherString is initialized with a literal...
        String anotherString = "Passed";
        
        if(passedOutput == anotherString) {
            System.out.println("passedOutput is in the *same memory location* as anotherPassedOutput.");
        }
        else {
            System.out.println("passedOutput is a different object than anotherPassedOutput.");
        }
        
        //But if anotherString is initialized to a new String object...
        anotherString = new String("Passed");
        
        if(passedOutput == anotherString) {
            System.out.println("passedOutput is in the *same memory location* as anotherPassedOutput.");
        }
        else {
            System.out.println("passedOutput is a different object than anotherPassedOutput.");
        }
        
        //If you compare directly to a literal, you could get lucky
        if(passedOutput == "Passed") {
            System.out.println("passedOutput might be in the same memory location as \"Passed\" (unreliable).");
        }
        
        //If you compare using String's .equals method you are much more likely to get accurate results
        if(passedOutput.equals("Passed")) {
            System.out.println("passedOutput has the same exact set of characters as \"Passed\".");
        }
        
        //And .equalsIgnoreCase, which doesn't care about each character's case
        if(passedOutput.equalsIgnoreCase("Passed")) {
            System.out.println("passedOutput is roughly the same characters as \"Passed\".");
        }
        
        //Comparing strings is also different:
        int cmp = passedOutput.compareTo("Passed");
        if(cmp < 0) {
            System.out.println("passedOutput is less than Passed lexigraphically");
        }
        else if(cmp > 0) {
            System.out.println("passedOutput is greater than \"Passed\" lexigraphically");
        }
        else { //cmp == 0
            System.out.println("passedOutput has the same exact set of characters as \"Passed\".");
        }
        
        //Note to compare *alphabetically* you would have to uppercase or lowercase both
        cmp = passedOutput.toUpperCase().compareTo("Passed".toUpperCase());
        if(cmp < 0) {
            System.out.println("passedOutput is less than Passed alphabetically");
        }
        else if(cmp > 0) {
            System.out.println("passedOutput is greater than \"Passed\" alphabetically");
        }
        else { //cmp == 0
            System.out.println("passedOutput has the same exact set of characters as \"Passed\".");
        }
    }
    
    /**
     * Branching logic to attempt the creation of a PB&J sandwich.
     * 
     * @return 
     */
    public static boolean tryToMakeSammich() {
        int bread = 8;
        int jelly = 1;
        int peanutButter = 1;
        double money = 42.00;
        
        if(bread > 0) {
            if(jelly > 0) {
                if(peanutButter > 0) {
                    return makeSammich();
                }
                else {
                    if(money > 0.00) {
                        return goToTheStore();
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                if(money > 0.00) {
                    return goToTheStore();
                }
                else {
                    return false;
                }
            }
        }
        else {
            if(money > 0.00) {
                return goToTheStore();
            }
            else {
                return false;
            }
        }
        
        /*if(bread > 0 && jelly > 0 && peanutButter > 0) {
            return makeSammich();
        }
        else if (money > 0.00) {
            return goToTheStore();
        }
        else {
            return false;
        }*/
    }

    private static boolean makeSammich() {
        return true; //Made a sammich!
    }
    
    private static boolean goToTheStore() {
        return false; //Maybe later
    }
}
