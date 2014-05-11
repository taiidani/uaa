package family;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Family {

    /**
     * Create a basic nuclear family tree.
     * 
     * The objects in this tree should be printable to the console and
     * able to display the pets that they own.
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        List<Person> people = new ArrayList<Person>();
        
        //Open the source of the People classes
        Scanner fInput = new Scanner(new FileInputStream("people.txt"));
        
        //Skip the header
        fInput.nextLine();
        
        //Loop through each person
        while(fInput.hasNextLine()) {

            //Read the entire line, then split it into an array using the tab character as a delimiter
            String tmp = fInput.nextLine();
            String[] splitLine = tmp.split("\t");
            
            //Parse the string array into a person object
            Person p = new Person(splitLine[0], splitLine[1]);
            p.setAge(Integer.parseInt(splitLine[2]));
            p.setWeight(Double.parseDouble(splitLine[3]));
            p.setHeight(splitLine[4]);
            
            //Add the new person object to the list of people
            people.add(p);
        }
        
        fInput.close();
        

        //Open the source of the Animal classes
        Scanner petInput = new Scanner(new FileInputStream("pets.txt"));
        
        //Skip the header
        petInput.nextLine();
        
        //Loop through each animal
        while(petInput.hasNextLine()) {

            //Read the entire line, then split it into an array using the tab character as a delimiter
            String tmp = petInput.nextLine();
            String[] splitLine = tmp.split("\t");
            
            //Parse the string array into an Animal object
            Animal a = new Animal();
            a.setType(splitLine[1]);
            a.setName(splitLine[2]);
            a.setAge(Integer.parseInt(splitLine[3]));
            
            //Find the animal's owner by first name
            for(Person p : people) {

                //If found, add the Animal as a pet for that person
                if(p.getFirst().equals(splitLine[0])) {
                    p.addPet(a);
                }
            }
        }
        
        petInput.close();
        
        //Call the static method on Person to have it describe all of the people
        System.out.println(Person.summarizeFamily(people));
    }
}
