package academicadvisor;

import java.util.Scanner;

public class AcademicAdvisor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //The highest course taken for Computer Science, Mathemematics, and 
        //Computer Systems Engineering, respectively
        int cs = 201;
        int math = 108;
        int cse = 205;
        
        //Declare this varible OUTSIDE of your if statements. Remember that an
        //if statement creates its own scope and you will need to use this variable
        //afterwards.
        int nextClass;
        
        if(cs == 241 || cse >= 215) {
            nextClass = 304;
        }
        else if((cs == 221 || cse >= 205) && math >= 107) {
            nextClass = 241;
        }
        else if(cs >= 201 && cs != 202) {
            nextClass = 202;
        }
        else if(cs >= 201) {
            nextClass = 221;
        }
        else {
            nextClass = 201;
        }
        
        //Output the advice
        System.out.println("Your next course should be: CS" + nextClass);
        
        //Prompt the user if the advice helped them
        System.out.print("Was this advice helpful? [Yes/No] ");
        String promptResponse = input.nextLine();
        
        if(promptResponse.equals("Yes")) {
            System.out.println("Glad to have helped!");
        }
        else if(promptResponse.equals("No")) {
            System.out.println("I'm sorry to hear that.");
        }
    }
}
