import java.util.ArrayList;

public class Planet {

    // top-right corner of the map (bottom-left is [0,0])
    private int maximumX;
    private int maximumY;

    // "drop off" scents left by other robots
    private ArrayList<String> scent;

    public Planet(int maximumX, int maximumY) {
        this.maximumY = maximumY;
        this.maximumX = maximumX;
        scent = new ArrayList<String>();
    }

    // Leave a scent to on this coordinate.
    public void leaveScent(int x, int y) {
        scent.add(x + "," + y);
    }

    // Does this coordinate have a scent?
    public boolean hasScent(int x, int y) {
        return scent.contains(x + "," + y);
    }

    // Are the coordinates inside the planet?
    public boolean checkOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x > maximumX || y > maximumY;
    }

}