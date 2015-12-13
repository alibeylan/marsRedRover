import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {


        // Initialising console reader
        Scanner s = new Scanner(System.in);

        // We create an ArrayList so the app can store and evaluate all the robots that the user inputs.
        Planet planet = null;
        ArrayList<Robot> robots = new ArrayList<Robot>();

        // Get planet's description.
        String planetSize;
        System.out.println("Let's make a planet!");

        // Set up planet's size by using the top right coordinates.
        while (planet == null) {
            System.out.print("\nPlease enter the planet's top-right coordinate x y : ");
            planetSize = s.nextLine();
            // check format of user input
            if (planetSize.matches("[0-9]+\\s+[0-9]+")) {
                String[] coordinateParts = planetSize.split("\\s+");
                planet = new Planet(Integer.parseInt(coordinateParts[0]), Integer.parseInt(coordinateParts[1]));
            } else {
                // loop to try again
                System.err.println("\nSomething went wrong... Please enter your planet size in the format x y");
                System.err.flush();
            }
        }

        //Get the robot's details.
        System.out.println("\n" +
                "Please input in the first line the robot's coordinates and orientation (e.g. 1 1 S). \n" +
                "In the second line enter the instructions that the robot has to follow.\n" +
                "- F states for move forward one step.\n" +
                "- L states for turning left.\n" +
                "- R states for turning right./n" +
                "When you are done, enter \"finish\" to continue.");

        int currentRobot = 1;
        Robot actualRobot;
        String inputPosition;
        String[] positionDescription;
        String instructions;
        while (true) {
            // Get robot's position and orientation from console.
            System.out.print("\nEnter the position and orientation for robot #" + currentRobot + " (e.g. 3 4 E): ");
            inputPosition = s.nextLine().toUpperCase();

            // Check if the user inputs the word "finish".
            if (inputPosition.toLowerCase().equals("finish")) break;

            // Verify that the input from the user is correct.
            if (inputPosition.matches("[0-9]+\\s+[0-9]+\\s+[NESW]")) {
                positionDescription = inputPosition.split("\\s+");

                // Verify if the input position is inside the bounds of planet.
                if (planet.checkBounds(Integer.parseInt(positionDescription[0]), Integer.parseInt(positionDescription[1]))) {
                    // loop to try again
                    System.err.println("\nPlease try to enter a position that is inside the bounds of the planet.");
                    System.err.flush();
                    continue;
                }

                // Start creating the robots.
                actualRobot = new Robot(Robot.Orientation.valueOf(positionDescription[2]), Integer.parseInt(positionDescription[0]), Integer.parseInt(positionDescription[1]));
            } else {
                System.err.println("\nPlease enter the robot's position in the format (x y z) where x and y are coordinates\n and where z is the orientation: N, E, S or W.");
                System.err.flush();
                continue;
            }
            System.out.print("Enter the commands for robot #" + currentRobot + " (e.g. FFLRFFRL): ");
            instructions = s.nextLine();

            // are we done?
            if (instructions.toLowerCase().equals("done")) break;

            // parse commands
            actualRobot.setInstructions(parseInstructions(instructions));

            // add to set and continue
            actualRobot.setPlanet(planet);
            robots.add(actualRobot);
            ++currentRobot;
        }
    }
        public static ArrayList<Instructions> parseInstructions(String input) {
            // set up output
            ArrayList<Instructions> output = new ArrayList<Instructions>();

            // split and loop through input
            String[] instructions = input.split("");
            for (String c : instructions) {
                // try to parse by matching to enum
                try {
                    output.add(Instructions.valueOf(c));
                } catch (IllegalArgumentException e) {
                    // ignore invalid commands
                }
            }

            return output;
        }

        public enum Instructions {
            F, L, R
        }
}