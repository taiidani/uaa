package classexamples;

/**
 * A simple representation of a rectangular shape.
 * 
 * This class allows setting the width and height of a rectangle as well
 * as outputting the calculated area of the shape.
 * 
 * There are 2 ways to store this area:
 * - Fast: Cache the area in an instance variable and return it with an accessor
 * - Small: Calculate the area upon each execution of the accessor
 * 
 * Note that width and height are always private. This prevents outside code
 * from setting them to invalid values such as a negative number
 * @author rnixon
 */
public class Rectangle {
    
    //Defines the area of the rectangle upon each call to the accessor
    //This method is slower but uses less memory, and ensures that
    //getArea() always produces an accurate area
    private int width;
    private int height;
    
    public int getArea() {
        return width * height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    //Defines and stores the area of the rectangle every time a mutator is
    //used. With this strategy the area is cached and improves the speed
    //of calls to getArea2(). It does however use more memory to cache the area
    private int area;
    public void setWidth(int width) {
        if(width > 0) {
            this.width = width;
        
            //Recalculate area
            area = width * height;
        }
    }
    
    public void setHeight(int height) {
        if(height > 0) {
            this.height = height;
            
            //Recalculate area
            area = width * height;
        }
    }
    
    public int getArea2() {
        //No need to calculate area again, the value is always reset at the
        //time that the width and height are changed
        return area;
    }
}
