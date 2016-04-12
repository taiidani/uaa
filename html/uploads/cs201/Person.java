package family;

import java.util.ArrayList;
import java.util.List;

public class Person {
    
    private String first;
    private String last;
    private int age;
    private double height;
    private double weight;
    
    private List<Animal> petsOwned;
    
    public Person(String first, String last) {
        this(first, last, 21);
    }
    
    public Person(String first, String last, int age) {
        this.first = first;
        this.last = last;
        this.age = age;
        
        petsOwned = new ArrayList<Animal>();
    }    
    
    
    /**
     * List all pets that this person owns in a String.
     */
    public String listPets() {
        String ret = "";
        
        for(Animal p : petsOwned) {
            ret += p + "\n";
        }
        
        return ret;
    }
    
    /**
     * Summarize the pets this person owns including their type, name, and age.
     * Also display the average age for all of the pets.
     */
    public String summarizePets() {
        String ret = "";
        int numPets = 0;
        int totalAge = 0;
        
        for(Animal p : petsOwned) {
            ret += p + "\n";
            
            totalAge += p.getAge();
            numPets++;
        }
        
        ret += "Number of pets: " + numPets + "\n";
        ret += "Average age: " + (totalAge / (double)numPets) + "\n";
        
        return ret;
    }
    
    
    
    
    public static String summarizeFamily(List<Person> family) {
        String ret = "";
        for(Person p : family) {
            ret += p + "\n" + p.summarizePets() + "\n\n";
        }
        
        return ret;
    }
    
    //Accessors & Mutators
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        if(last.length() == 0) return;
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeight(double height) {
        setHeight(height, "in");
    }
    
    public void setHeight(double height, String unit) {
        if(unit.equals("ft")) this.height = height * 12;
        else if(unit.equals("in")) this.height = height;
    }
    
    public void setHeight(String height) {
        String[] splitHeight = height.split("'");
        int feet = Integer.parseInt(splitHeight[0]);
        int inches = Integer.parseInt(splitHeight[1].replace('"', ' ').trim());
        
        this.setHeight(feet * 12 + inches);
    }
    
    public void addPet(String type, String name) {
        addPet(type, name, 0);
    }

    public void addPet(String type, String name, int age) {
        Animal p = new Animal();
        p.setType(type);
        p.setName(name);
        p.setAge(age);
        
        addPet(p);
    }
    
    public void addPet(Animal pet) {
        petsOwned.add(pet);
    }
    
    
    public String toString() {
        return first + " " + last + " (" + age + ")";
    }
}
