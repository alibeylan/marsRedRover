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
    public Robot(Orientation orientation, int locX, int locY) {
        this.orientation = orientation;
        this.locX = locX;
        this.locY = locY;
    }

    //Tells the that is living in a planet that the user set before using the planet class.
    public void setPlanet(Planet planet) {

        this.planet = planet;
    }

    public void setInstructions(ArrayList<Main.Instructions> commands) {
        this.instructions = commands;
    }

    // Execute the main class to process the robot and evaluate position.
    public void executeMain() {
        // Verify if the robot is already on a planet.
        if (planet == null) {
            System.out.println("The robot is not on a planet.");
            return;
        }

        // Verify if we received instructions as an input for that robot.
        if (instructions == null || instructions.isEmpty()) {
            System.out.println("No instructions given to the robot.");
            return;
        }

        // run through the mission
        for (Main.Instructions i : instructions) {
            executeInstructions(i);
            if (lost) break;
        }
    }

    //Execute the instructions determined on the bottom.
    private void executeInstructions(Main.Instructions instructions) {
        switch (instructions) {
            case L:
                turnLeft();
                break;

            case R:
                turnRight();
                break;

            case F:
                moveForwards();
                break;
        }
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
                ++locY;
                break;
            case E:
                ++locX;
                break;
            case S:
                --locY;
                break;
            case W:
                --locX;
                break;
        }

        //Check if the robot is on the edge.
        if (planet.checkOutOfBounds(locX, locY)) {
            // was there a scent here previously?
            if (planet.hasScent(oldX, oldY)) {
                // ignore the command and go back to our previous position
                locX = oldX;
                locY = oldY;
            } else {
                // uh-oh, we're lost!
                lost = true;

                // store our last location
                locX = oldX;
                locY = oldY;

                // leave a scent so that no one follows us
                planet.leaveScent(oldX, oldY);
            }
        }
    }

    public String toString() {
        return locX + " " + locY + " " + orientation.toString() + (lost ? " LOST" : "");
    }
        public enum Orientation {
            N, E, S, W
        }

    }
