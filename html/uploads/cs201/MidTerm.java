package midterm;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MidTerm {
    
    public static void main(String args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<Flight>();
        
        System.out.print("What is your originating flight? ");
        String origin = keyboard.nextLine();
        
        do {
            try {
                Flight f = new Flight();
                System.out.println("Please enter destination " + (flights.size() + 1) + " or press enter to end.");

                System.out.print("Name? ");
                f.setDestination(keyboard.nextLine());

                //The exit condition
                if(f.getDestination().equals("")) break;

                System.out.print("Distance? ");
                f.setDistance(keyboard.nextInt());

                flights.add(f);
            }
            catch(InputMismatchException ex) {
                System.out.println("I don't understand.");
                System.out.println(ex.getMessage());
            }
            finally {
                keyboard.nextLine();
            }
            
        } while(true);
        
        System.out.println();
        
        printItinerary(origin, flights);
    }
    
    public static void printItinerary(String origin, ArrayList<Flight> flights) throws Exception {
        int distance = 0;
        
        System.out.println("Here is your itinerary flying from " + origin + ":");
        for(Flight f : flights) {
            System.out.println(f);
            
            //Add to the total trip distance
            distance += f.getDistance();
        }
        
        System.out.println("Your total flight distance is " + distance + " miles.");
        
        if(flights.size() > 4 || distance > 5000) throw new Exception("Sorry, that's way too terrible of a flight plan.");
    }
    
    
}
