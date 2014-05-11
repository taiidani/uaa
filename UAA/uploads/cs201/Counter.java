package counter;

public class Counter {

    /**
     * A persistent class-level variable to hold the current count.
     * Being static, this variable will exist throughout the entire
     * duration of the program.
     */
    private static int count;
    
    public static void main(String[] args) {
        reset();

	increment(5);
	decrement(3);

	//Displays 2
	System.out.println("The current amount is " + current());

	increment(4);

	//Displays 6 
	System.out.println("The amount has been increased to " + current());

	reset();

	//Displays 0
	System.out.println("After resetting, the value has become " + current());
    }
    
    /**
     * Resets the static count variable back to zero, forgetting
     * all of the counting done so far.
     */
    public static void reset() {
        count = 0;
    }
    
    /**
     * Gets the current value of the class-level count variable.
     * 
     * @return The current count
     */
    public static int current() {
        return count;
    }
    
    /**
     * Increases the count by the specified amount
     * 
     * @param amount How much to increase the count by
     */
    public static void increment(int amount) {
        count += amount;
    }
    
    /**
     * Decreases the count by the specified amount
     * 
     * @param amount How much to decrease the count by
     */
    public static void decrement(int amount) {
        count -= amount;
    }
}
