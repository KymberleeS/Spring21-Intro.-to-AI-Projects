import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int environmentChoice = 0;

        while (environmentChoice != 3) {
            // creating a menu for the users to select and environment or exit
            System.out.println("Please Select an Environment (1-3):");
            System.out.println("1. Original Environment\n2. 'Sea of Triangles' Environment\n3. Exit");
            System.out.println("");

            // storing user input in an environment choice variable
            environmentChoice = userInput.nextInt();

            // creating the switch case to correspond with the menu
            switch(environmentChoice) {
                // prompting user to enter a budget before showing the resulting environment (original) when choosing this option
                case 1:
                    PolygonEnvironment environment = new PolygonEnvironment();

                    while (environment.budget != -1) {
                        environment.budget = environment.maxBudget();
                        if (environment.budget == -1) {
                            System.out.println("Returning to previous menu . . .");
                            System.out.println("");
                            break;
                        }

                        JFrame frame = new JFrame();
                        frame.setSize(1500, 700);
                        frame.setLocationRelativeTo(null);
                        frame.setTitle("Polygon Obstacle Course");

                        frame.setContentPane(environment);

                        frame.setVisible(true);
                        frame.invalidate();
                    }
                    break;

                // prompting user to enter a budget before showing the resulting environment (triangle) when choosing this option
                case 2:
                    PolygonEnvironment2 environment2 = new PolygonEnvironment2();

                    while (environment2.budget != -1) {
                        environment2.budget = environment2.maxBudget();
                        if (environment2.budget == -1) {
                            System.out.println("Returning to previous menu . . .");
                            System.out.println("");
                            break;
                        }

                        JFrame frame = new JFrame();
                        frame.setSize(1500, 700);
                        frame.setLocationRelativeTo(null);
                        frame.setTitle("Polygon Obstacle Course");

                        frame.setContentPane(environment2);

                        frame.setVisible(true);
                        frame.invalidate();
                    }
                    break;

                // exits the application when the user chooses this option
                case 3:
                    System.out.println("Stopping Application . . .");
                    break;

                // shows user a warning message if their input is invalid
                default:
                    System.out.println("invalid choice, please try again");
                    break;
            }
        }

        userInput.close();
        System.exit(0);
    }
}
