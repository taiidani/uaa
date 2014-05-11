package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {
    
    public static void main(String args) {
        //TODO Use polymorpism to allow other animals
        
        try {
            Predatory hawky = new Hawk();
            Predatory wolfy = new Wolf();
            hawky.attack(wolfy);
            
            
            Feline simba = new Lion("Simba");
            Feline scar = new Lion("Scar");

            System.out.printf("Don't do it, %s!\n", scar);
            scar.attack(simba);

            if(!simba.isAlive()) throw new ParadoxException("Huh, a paradox.");
            else System.out.printf("You're alive, %s! Well, it's off to Hakuna Matata for you.\n", simba);

            System.out.println("Seriously, just grow up.");
            simba.setAge(simba.getAge() + 5);
            System.out.println("But before you go back, you should sleep tonight.");
            simba.sleep(10);

            System.out.println("Alright, let's see those kingly claws.");
            simba.clawsExtend();

            System.out.printf("Cya later, %s!\n", scar);
            simba.attack(scar);

            if(!scar.isAlive()) System.out.println("And that's the circle of life!");
            else throw new ParadoxException("Huh, a paradox.");



            List<Animalia> kingdom = new ArrayList<Animalia>();
            kingdom.add(simba);
            kingdom.add(scar);

            System.out.printf("\n\n%s has saved all of the animals in the kingdom!", simba);
            for(Animalia animal : kingdom) {
                if(animal.isAlive()) {
                    System.out.println(animal + " rejoices.");
                }
            }
        }
        catch(ParadoxException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
