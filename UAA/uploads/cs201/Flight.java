
package midterm;

public class Flight {
    private String destination;
    private int distance;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public String toString() {
        return destination + " (" + distance + ") miles";
    }
    
    
}
