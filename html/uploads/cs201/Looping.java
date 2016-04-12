package looping;

import java.util.Scanner;

public class Looping {

    public static void main(String[] args) {
        //********************************************************************************
        //Write a do-while loop that requests a person's name from the console repeatedly until
        //they guess correctly. A user can submit a blank guess to exit the loop
        Scanner input = new Scanner(System.in);
        String name = "Stacey";
        String guess = "";
        
        while(!guess.equals(name)) {
            System.out.print("What is my name? ");
            guess = input.nextLine();
            
            if(!guess.equals(name)) {
                System.out.println("That's not my name.");
            }
            
            
        }
        
        System.out.println("You guessed correctly.");
        
        
        //********************************************************************************
        //Write a for loop that will count the number of blank characters in a given string.
        String stringWithBlanks = "Hey, who turned out the lights?";
        int blankCount = 0;
        
        for(int cnt = 0; cnt < stringWithBlanks.length(); cnt++) {
            if(stringWithBlanks.charAt(cnt) == ' ') blankCount++;
        }
        
        System.out.println("\nNumber of blanks: " + blankCount);
        
        
        //********************************************************************************
        //Write a for loop that will create a new string that is the reverse of a given string.
        String givenString = "Allons-y!";
        String reversedString = "";

        for(int cnt = givenString.length() - 1; cnt >= 0; cnt--) {
            reversedString += givenString.charAt(cnt);
        }
        
        System.out.println("\nNormal: " + givenString);
        System.out.println("Reversed: " + reversedString);
    }
}
