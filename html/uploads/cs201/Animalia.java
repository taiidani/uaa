package inheritance;

public class Animalia {
    
    protected int age;
    protected boolean isAlive;
    protected String name;
    
    public Animalia() {
        isAlive = true;
    }
    
    public Animalia(String name) {
        this();
        this.name = name;
    }
    
    public void sleep(int seconds) {
        try {
            System.out.printf("\t%s sleeps for %d seconds.\n", this, seconds);
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException e) {
            //Woke up early
        }
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void die() {
        isAlive = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
}
