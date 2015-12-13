import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String... args){


        // Initialising console reader
        Scanner s = new Scanner (System.in);

        // We create an ArrayList so the app can store and evaluate all the robots that the user inputs.
        Planet planet = null;
        ArrayList<Robot> robots = new ArrayList<Robot>();

        // Get planet description.
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


    }
}