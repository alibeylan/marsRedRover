import java.util.ArrayList;

public class Robot {
    //Orientation and Position of the robot
    private Orientation orientation;
    private int locX;
    private int locY;

    //Using the planet class to tell the robot's planet.
    private Planet planet = null;

    private boolean lost = false;

    // mission statement
    private ArrayList<Main.Instructions> instructions = null;

    //Initialise robot's position with orientation
    public Robot(Orientation orientation, int xLoc, int yLoc) {
        this.orientation = orientation;
        this.locX = xLoc;
        this.locY = yLoc;
    }

    //Tells the that is living in a planet that the user set before usiing the planet class.
    public void setPlanet(Planet planet) {

        this.planet = planet;
    }

    public void setInstructions(ArrayList<Main.Instructions> commands) {
        this.instructions = commands;
    }
    /*Describe the moves that the robot has to make to turn or go forward */

    // Turn left move
    private void turnLeft() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case E:
                orientation = Orientation.N;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
        }
    }

    // Turn right move
    private void turnRight() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
        }
    }

    // Go forward move
    private void moveForwards() {
        // store the old location
        int oldX = locX;
        int oldY = locY;

        // go to the new position
        switch (orientation) {
            case N:
                ++locX;
                break;
            case E:
                ++locY;
                break;
            case S:
                --locY;
                break;
            case W:
                --locX;
                break;
        }
    }
        public enum Orientation {
            N, E, S, W
        }

    }
