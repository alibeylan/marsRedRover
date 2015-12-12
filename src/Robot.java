public class Robot {
    //Orientation and Position of the robot
    private Orientation orientation;
    private int locX;
    private int locY;


    //Initialise robot's position with orientation
    public Robot(Orientation orientation, int xLoc, int yLoc) {
        this.orientation = orientation;
        this.locX = xLoc;
        this.locY = yLoc;
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
