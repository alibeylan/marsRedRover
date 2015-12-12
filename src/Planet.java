import java.util.ArrayList;

public class Planet {

    // top-right corner of the map (bottom-left is [0,0])
    private int maxX;
    private int maxY;

    // "drop off" scents left by other robots
    private ArrayList<String> scent;

    public Planet(int xMax, int yMax) {
        this.maxX = maxX;
        this.maxY = maxY;
        scent = new ArrayList<String>();
    }

    // leave a "drop off" scent at a given coordinate
    public void leaveScent(int x, int y) {
        scent.add(x + "," + y);
    }

    // does a given coordinate have a "drop off" scent?
    public boolean hasScent(int x, int y) {
        return scent.contains(x + "," + y);
    }

    // are a set of coordinates out of bounds for this planet?
    public boolean checkOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x > maxX || y > maxY;
    }

}